package com.example.storelego.data.model

import android.os.Parcelable
import com.example.storelego.domain.model.Product
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductConteinerResponse(val results: List<ProductResponse>): Parcelable

@Parcelize
data class ProductResponse(val id: Int?,
                           val name: String?,
                           val unitPrice: Int?,
                           val stock: Int?,
                           val image: String?): Parcelable


fun ProductConteinerResponse.toProductList(): List<Product> = results.mapNotNull { it.toProduct() }

fun ProductResponse.toProduct(): Product? =
    if (name.isNullOrBlank() || unitPrice==null || stock==null || image.isNullOrBlank()) {
        null
    } else {
        Product(name, unitPrice, stock, image)
    }