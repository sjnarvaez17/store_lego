package com.example.storelego.domain.repository

import com.example.storelego.domain.model.Product

interface GetProductRepo {

    suspend fun getProductRepo(): List<Product>
}