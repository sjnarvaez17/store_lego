package com.example.storelego.domain.use_case

import com.example.storelego.domain.repository.GetProductDetailRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val productDetailRepo: GetProductDetailRepo, dispatcher: CoroutineDispatcher) {

    operator fun invoke(productId: String) = productDetailRepo.getProductDetail(productId)
}