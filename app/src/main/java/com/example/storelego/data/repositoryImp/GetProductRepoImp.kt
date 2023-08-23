package com.example.storelego.data.repositoryImp

import com.example.storelego.core.functional.Response
import com.example.storelego.data.service.GetProductService
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.repository.GetProductRepo
import javax.inject.Inject

class GetProductRepoImp @Inject constructor(private val getProductService: GetProductService):
    GetProductRepo {

    override fun getProductRepo(): Response<List<Product>> {
        TODO("Not yet implemented")
    }
}