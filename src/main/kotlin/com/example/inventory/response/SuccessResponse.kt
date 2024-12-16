package com.example.inventory.response

data class SuccessResponse(
    val status: String = "success",
    val data: Any? = null
)