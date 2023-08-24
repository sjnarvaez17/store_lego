package com.example.storelego.data.repository

import com.example.storelego.core.functional.Response
import com.example.storelego.data.source.ProductRemoteDataSource
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.repository.GetProductDetailRepo
import javax.inject.Inject

class GetProductDetailRepoImpl @Inject constructor(private val getProductRemoteDataSource: ProductRemoteDataSource) :
    GetProductDetailRepo {

    override fun getProductDetail(id: String): Response<ProductDetail> {
        TODO("Not yet implemented")
    }
}