package com.example.storelego.data.service

import android.util.Log
import com.example.storelego.core.functional.Failure
import com.example.storelego.core.functional.Response
import com.example.storelego.core.functional.Success
import com.example.storelego.core.utils.HTTP_400
import com.example.storelego.core.utils.HTTP_500
import com.example.storelego.data.api.ProductApi
import com.example.storelego.data.model.toProductList
import com.example.storelego.domain.model.Product
import retrofit2.Retrofit
import javax.inject.Inject

class GetProductService @Inject constructor(private val retrofit: Retrofit){

    fun fetchProductList(): Response<List<Product>> {
        return try {
            val httpResponse = retrofit.create(ProductApi::class.java).fetchProductsList().execute()

            if (httpResponse.isSuccessful) {
                val value = httpResponse.body()?.toProductList().orEmpty()
                Response(Success(value), null)
            } else {
                when (httpResponse.code()) {
                    in HTTP_400 -> Response(null, Failure.ServerNotFound)
                    in HTTP_500 -> Response(null, Failure.ServerError)
                    else -> Response(null, Failure.NetworkError)
                }
            }
        } catch (exception: Exception) {
            Log.e(javaClass.name, exception.toString())
            Response(null, Failure.NetworkError)
        }
    }
}