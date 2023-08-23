package com.example.storelego.domain.repository

import com.example.storelego.core.functional.Response
import com.example.storelego.domain.model.ProductDetail

interface GetProductDetailRepo {

    fun getProductDetail(id: String): Response<ProductDetail>
}