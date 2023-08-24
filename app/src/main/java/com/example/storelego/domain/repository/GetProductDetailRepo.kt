package com.example.storelego.domain.repository

import com.example.storelego.domain.model.ProductDetail

interface GetProductDetailRepo {

    suspend fun getProductDetail(id: String): ProductDetail?
}