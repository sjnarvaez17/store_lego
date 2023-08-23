package com.example.storelego.data.service

import android.util.Log
import com.example.storelego.core.functional.Failure
import com.example.storelego.core.functional.Response
import com.example.storelego.core.functional.Success
import com.example.storelego.core.utils.HTTP_400
import com.example.storelego.core.utils.HTTP_500
import com.example.storelego.data.api.ProductApi
import com.example.storelego.data.model.toProductDetail
import com.example.storelego.domain.model.ProductDetail
import retrofit2.Retrofit
import javax.inject.Inject

class GetProductDetailService @Inject constructor(private val retrofit: Retrofit){

    fun fetchProductDetails(id: String): Response<ProductDetail> {
        return try {
            val httpResponse =
                retrofit.create(ProductApi::class.java).fetchProductDetails(id).execute()

            if (httpResponse.isSuccessful) {
                httpResponse.body()?.let { response ->
                    response.toProductDetail()?.let { Response(Success(it)) } ?: Response()
                } ?: Response(failure = Failure.GenericFailure)
            } else {
                when (httpResponse.code()) {
                    in HTTP_400 -> Response(failure = Failure.ServerNotFound)
                    in HTTP_500 -> Response(failure = Failure.ServerError)
                    else -> Response(failure = Failure.NetworkError)
                }
            }
        } catch (exception: Exception) {
            Log.e(javaClass.name, exception.toString())
            Response(failure = Failure.NetworkError)
        }
    }
}