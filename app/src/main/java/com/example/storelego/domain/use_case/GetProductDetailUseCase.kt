package com.example.storelego.domain.use_case

import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(productId: String): Response<ProductDetail?> {
        return withContext(dispatcher) {
            try {
                val productDetail = productRepository.getProductDetail(productId)
                Response(success = Success(productDetail))
            } catch (exception: Exception) {
                Response(failure = Failure(exception))
            }
        }
    }
}
