package com.example.storelego.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.use_case.GetProductDetailUseCase
import com.example.storelego.domain.use_case.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _productDetail = MutableLiveData<ProductDetail>()
    val productDetail: LiveData<ProductDetail> get() = _productDetail

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception>
        get() = _error

    fun getProductDetail(id: String) {
        viewModelScope.launch(dispatcher) {
            try {
                val productListUseCaseResult: Response<ProductDetail?> = getProductDetailUseCase(id)

                if (productListUseCaseResult.isSuccess) {
                    productListUseCaseResult.success?.value?.let {
                        _productDetail.postValue(it)
                    } ?: run {
                        _error.postValue(Exception("No data found"))
                    }
                } else {
                    _error.postValue(productListUseCaseResult.failure?.exception)
                }
            } catch (exception: Exception) {
                _error.postValue(exception)
            }
        }

    }
}
