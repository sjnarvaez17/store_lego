package com.example.storelego.domain.repository

import com.example.storelego.core.functional.Response
import com.example.storelego.domain.model.Product

interface GetProductRepo {

    fun getProductRepo(): Response<List<Product>>
}