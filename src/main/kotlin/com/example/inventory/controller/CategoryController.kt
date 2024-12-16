package com.example.inventory.controller

import com.example.inventory.dto.CategoryDto
import com.example.inventory.response.SuccessResponse
import com.example.inventory.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/categories")
class CategoryController {
    @Autowired
    lateinit var categoryService: CategoryService

    @GetMapping
    fun list(): ResponseEntity<*> {
        val response = categoryService.list()
        return ResponseEntity.ok(SuccessResponse(data=response))
    }
    @PostMapping
    fun create(@RequestBody categoryDto: CategoryDto): ResponseEntity<*> {
        val response = categoryService.create(categoryDto)
        return ResponseEntity.ok(SuccessResponse(data=response))
    }


}