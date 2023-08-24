package com.example.storelego.domain.use_case

data class Response<T>(
    val success: Success<T>? = null,
    val failure: Failure? = null
) {

    companion object {
        private const val ILLEGAL_STATE_EXCEPTION_MESSAGE =
            "Response can't be success and failure at the same time"
    }

    private val isResponseInvalid by lazy { success != null && failure != null }
    val isSuccess by lazy { checkSuccess() }

    init {
        if (isResponseInvalid) {
            throw IllegalStateException(ILLEGAL_STATE_EXCEPTION_MESSAGE)
        }
    }

    private fun checkSuccess(): Boolean {
        if (isResponseInvalid) {
            throw IllegalStateException(ILLEGAL_STATE_EXCEPTION_MESSAGE)
        }

        return success != null
    }
}

data class Success<T>(val value: T)

data class Failure(val exception: Exception)
