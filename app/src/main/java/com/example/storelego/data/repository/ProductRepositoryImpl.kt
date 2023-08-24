package com.example.storelego.data.repository

import com.example.storelego.data.source.ProductRemoteDataSource
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun getProductList(): List<Product> =
        productRemoteDataSource.fetchProductList()

    override suspend fun getProductDetail(productId: String): ProductDetail? =
        productRemoteDataSource.fetchProductDetails(productId)
}