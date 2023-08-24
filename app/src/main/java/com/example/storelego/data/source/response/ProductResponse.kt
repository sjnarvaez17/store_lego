package com.example.storelego.data.source.response

import android.os.Parcelable
import com.example.storelego.domain.model.Product
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductListResponse(
    val products: List<ProductResponse?>?
) : Parcelable

@Parcelize
data class ProductResponse(
    val id: Int?,
    val name: String?,
    @SerializedName("unit_price") val unitPrice: Int?,
    val stock: Int?,
    val image: String?
) : Parcelable

fun ProductListResponse.toProductList(): List<Product> = products?.mapNotNull { it?.toProduct() }.orEmpty()

fun ProductResponse.toProduct(): Product? =
    if (id == null || name.isNullOrBlank() || unitPrice == null || stock == null || image.isNullOrBlank()) {
        null
    } else {
        Product(id, name, unitPrice, stock, image)
    }
