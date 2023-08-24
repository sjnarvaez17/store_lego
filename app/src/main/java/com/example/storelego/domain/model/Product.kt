package com.example.storelego.domain.model

data class Product (
    val id: Int,
    val name: String,
    val unitPrice: Int,
    val stock: Int,
    val image: String
)
