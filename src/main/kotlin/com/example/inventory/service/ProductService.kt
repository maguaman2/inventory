package com.example.inventory.service

import com.example.inventory.dto.ProductDto
import com.example.inventory.entity.Product
import com.example.inventory.mapper.ProductMapper
import com.example.inventory.repository.CategoryRepository
import com.example.inventory.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService {

    @Autowired
    lateinit var productRepository: ProductRepository

    @Autowired
    lateinit var categoryRepository: CategoryRepository


    fun list(): List<Product?> {
        return productRepository.findAll()
    }

    // Creacion de un producto y uso de transacciones en dos tablas
    @Transactional
    fun create(productDto: ProductDto): Product {
        //1. Verifica que existe y obtiene la categoria
        val categoryResponse =categoryRepository.findById(productDto.categoryId)
            ?: throw Exception("Category not found")
        //2. Mapea el dto a entidad producto
        val product = ProductMapper.toEntity(productDto)
        //3. Creacion del producto
        val newProduct = productRepository.save(product)
        //4. Suma de la multiplicacion de pvp por stock de la categoria a la que pertenece el producto
        val sum = productRepository.sumPvpTimesStock(product.category?.id)
        //5. Actualiza el valor de la inversion de la categoria
        categoryRepository.save(categoryResponse.apply {
            investment = sum
        })
        //6. Retorna el producto creado en el paso 3
        return newProduct


    }
}