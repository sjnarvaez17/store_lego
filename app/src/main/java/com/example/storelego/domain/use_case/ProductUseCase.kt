package com.example.storelego.domain.use_case

import com.example.storelego.domain.repository.GetProductRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepo: GetProductRepo, dispatcher: CoroutineDispatcher) {

    operator fun invoke() = productRepo.getProductRepo()
}