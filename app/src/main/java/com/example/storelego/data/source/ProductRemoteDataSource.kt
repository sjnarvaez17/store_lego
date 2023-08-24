package com.example.storelego.data.source

import com.example.storelego.data.source.response.toProductDetail
import com.example.storelego.data.source.response.toProductList
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.model.ProductDetail
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(private val productApi: ProductApi) {

    suspend fun fetchProductList(): List<Product> = productApi
        .fetchProductsList()
        .toProductList()

    suspend fun fetchProductDetails(id: String): ProductDetail? = productApi
        .fetchProductDetails(id)
        .toProductDetail()
}
