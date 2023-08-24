package com.example.storelego.data.repository

import com.example.storelego.core.functional.Response
import com.example.storelego.data.source.ProductRemoteDataSource
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.repository.GetProductRepo
import javax.inject.Inject

class GetProductRepoImp @Inject constructor(private val getProductRemoteDataSource: ProductRemoteDataSource):
    GetProductRepo {

    override suspend fun getProductRepo(): List<Product> = getProductRemoteDataSource.fetchProductList()
}