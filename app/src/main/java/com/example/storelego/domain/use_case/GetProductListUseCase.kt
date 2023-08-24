package com.example.storelego.domain.use_case

import com.example.storelego.domain.model.Product
import com.example.storelego.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Response<List<Product>> {
        return withContext(dispatcher) {
            try {
                val productList = productRepository.getProductList()
                Response(success = Success(productList))
            } catch (exception: Exception) {
                Response(failure = Failure(exception))
            }
        }
    }
}
