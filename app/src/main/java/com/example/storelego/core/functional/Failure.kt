package com.example.storelego.core.functional

sealed class Failure {

    object GenericFailure: Failure()
    object ServerError: Failure() //HTTP 500
    object ServerNotFound: Failure() //HTTP 4O0
    object NetworkError: Failure() //Generic network error
    object LocalDatabaseError: Failure()
    object ExpectedParamMissing: Failure()
}