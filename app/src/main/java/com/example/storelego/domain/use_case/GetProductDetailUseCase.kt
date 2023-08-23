package com.example.storelego.domain.use_case

import com.example.storelego.domain.repository.GetProductDetailRepo
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val productDetailRepo: GetProductDetailRepo) {

    operator fun invoke(productId: String) = productDetailRepo.getProductDetail(productId)
}