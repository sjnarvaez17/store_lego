package com.example.storelego.domain.use_case

import com.example.storelego.domain.repository.GetProductRepo
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepo: GetProductRepo) {



}