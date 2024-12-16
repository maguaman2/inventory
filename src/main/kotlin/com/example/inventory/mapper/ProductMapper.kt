package com.example.inventory.mapper


import com.example.inventory.dto.ProductDto
import com.example.inventory.entity.Category
import com.example.inventory.entity.Product
import org.springframework.stereotype.Component

@Component
object ProductMapper {

    fun toEntity(productDto: ProductDto): Product {
        return Product().apply {
            description = productDto.description
            stock = productDto.stock
            pvp = productDto.pvp
            category = Category().apply {
                id = productDto.categoryId
            }
        }
    }
}