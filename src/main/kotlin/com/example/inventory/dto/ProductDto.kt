package com.example.inventory.dto

data class ProductDto(
    val id: Long?,
    val description: String?,
    val stock: Int?,
    val pvp: Double?,
    val categoryId:Long?
)
