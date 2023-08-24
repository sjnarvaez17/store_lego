package com.example.storelego.data.repository

import com.example.storelego.data.source.ProductRemoteDataSource
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.repository.GetProductDetailRepo
import javax.inject.Inject

class GetProductDetailRepoImpl @Inject constructor(private val getProductRemoteDataSource: ProductRemoteDataSource) :
    GetProductDetailRepo {

    override suspend fun getProductDetail(productId: String): ProductDetail? =
        getProductRemoteDataSource.fetchProductDetails(productId)
}