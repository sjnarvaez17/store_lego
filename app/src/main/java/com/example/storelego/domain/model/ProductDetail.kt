package com.example.storelego.domain.model

data class ProductDetail (
    val id: Int,
    val name: String,
    val unitPrice: Int,
    val stock: Int,
    val image: String,
    val description: String
)