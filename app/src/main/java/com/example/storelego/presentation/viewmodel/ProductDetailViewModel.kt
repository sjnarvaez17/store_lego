package com.example.storelego.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.use_case.Failure
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

    private val _error = MutableLiveData<Failure>()
    val error: LiveData<Failure>
        get() = _error

    fun getProductDetail(id: String) {
        viewModelScope.launch(dispatcher) {
            try {
                val productListUseCaseResult: Response<ProductDetail?> = getProductDetailUseCase(id)

                if (productListUseCaseResult.isSuccess) {
                    productListUseCaseResult.success?.value?.let {
                        _productDetail.postValue(it)
                    } ?: run {
                        _error.postValue(Failure(Exception("No data found")))
                    }
                } else {
                    _error.postValue(productListUseCaseResult.failure ?: Failure(Exception()))
                }
            } catch (exception: Exception) {
                _error.postValue(Failure(exception))
            }
        }
    }
}
