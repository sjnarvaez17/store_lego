package com.example.storelego.domain.repository

import com.example.storelego.core.functional.Response
import com.example.storelego.domain.model.Product
import javax.inject.Singleton

interface GetProductRepo {

    fun getProductRepo(): Response<List<Product>>
}