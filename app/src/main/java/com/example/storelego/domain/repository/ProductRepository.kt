package com.example.storelego.domain.repository

import com.example.storelego.domain.model.Product
import com.example.storelego.domain.model.ProductDetail

interface ProductRepository {

    suspend fun getProductList(): List<Product>

    suspend fun getProductDetail(productId: String): ProductDetail?
}