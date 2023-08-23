package com.example.storelego.data.repositoryImp

import com.example.storelego.core.functional.Response
import com.example.storelego.data.service.GetProductDetailService
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.repository.GetProductDetailRepo
import javax.inject.Inject

class GetProductDetailRepoImp @Inject constructor(private val getProductDetailService: GetProductDetailService): GetProductDetailRepo {

    override fun getProductDetail(id: String): Response<ProductDetail> {
        TODO("Not yet implemented")
    }
}