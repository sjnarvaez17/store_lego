package com.example.storelego.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.use_case.GetProductListUseCase
import com.example.storelego.domain.use_case.Response
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val productListUseCase: GetProductListUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception>
        get() = _error

    fun getProductList() {
        viewModelScope.launch(dispatcher) {
            try {
                val productListUseCaseResult: Response<List<Product>> = productListUseCase()

                if (productListUseCaseResult.isSuccess) {
                    productListUseCaseResult.success?.value?.let {
                        _productList.postValue(it)
                    } ?: run {
                        _productList.postValue(emptyList())
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
