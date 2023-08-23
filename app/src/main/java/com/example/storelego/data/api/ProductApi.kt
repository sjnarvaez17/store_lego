package com.example.storelego.data.api

import com.example.storelego.data.model.ProductConteinerResponse
import com.example.storelego.data.model.ProductDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    companion object {
        private const val DEFAULT_LIMIT = 2
        private const val DEFAULT_OFFSET = 0
    }

    @GET("/allProducts")
    fun fetchProductsList(
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("offset") offset: Int = DEFAULT_OFFSET
    ): Call<ProductConteinerResponse>

    @GET("/detail?id={productId}")
    fun fetchProductDetails(@Path("productId") id: String): Call<ProductDetailResponse>
}