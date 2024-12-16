package com.example.inventory.controller

import com.example.inventory.dto.ProductDto
import com.example.inventory.response.SuccessResponse
import com.example.inventory.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/products")
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list(): ResponseEntity<*> {
        val response = productService.list()
        return ResponseEntity.ok(SuccessResponse(data=response))
    }
    @PostMapping
    fun create(@RequestBody productDto: ProductDto): ResponseEntity<*> {
        val response = productService.create(productDto)
        return ResponseEntity.ok(SuccessResponse(data=response))
    }

}