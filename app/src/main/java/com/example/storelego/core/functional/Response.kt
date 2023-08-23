package com.example.storelego.core.functional

data class Response<T>(
    val success: Success<T>? = null,
    val failure: Failure? = Failure.GenericFailure
) {
    fun isSuccess() = success != null
}