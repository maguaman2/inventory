package com.example.inventory.service
import com.example.inventory.dto.CategoryDto
import com.example.inventory.entity.Category
import com.example.inventory.repository.CategoryRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService {

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    fun list(): List<Category?> {
        return categoryRepository.findAll()
    }

    fun create(categoryDto: CategoryDto): Category {
        val category = Category().apply {
            description = categoryDto.description
        }
        return categoryRepository.save(category)
    }


}