package com.example.inventory.mapper


import com.example.inventory.dto.CategoryDto
import com.example.inventory.entity.Category
import org.springframework.stereotype.Component

@Component
object CategoryMapper {

    fun toEntity(categoryDto: CategoryDto): Category {
        return Category().apply {
            description = categoryDto.description
        }
    }
}