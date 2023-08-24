package com.example.storelego.data.source

import com.example.storelego.data.source.response.ProductListResponse
import com.example.storelego.data.source.response.ProductDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    companion object {
        const val BASE_URL = "https://us-central1-api-back-admission-test.cloudfunctions.net/"

        private const val GET_ALL_PRODUCTS_PARTICLE = "/allProducts"
        private const val GET_DETAIL_PRODUCT = "/detail"

        private const val QUERY_ID = "id"
    }

    @GET(GET_ALL_PRODUCTS_PARTICLE)
    suspend fun fetchProductsList(): ProductListResponse

    @GET(GET_DETAIL_PRODUCT)
    suspend fun fetchProductDetails(
        @Query(QUERY_ID) id: String
    ): ProductDetailResponse
}
