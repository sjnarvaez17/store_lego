package com.example.storelego.data.source.response

import android.os.Parcelable
import com.example.storelego.domain.model.ProductDetail
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetailResponse(
    val id: Int?,
    val name: String?,
    @SerializedName("unit_price") val unitPrice: Int?,
    val stock: Int?,
    val image: String?,
    val description: String?
) : Parcelable

fun ProductDetailResponse.toProductDetail(): ProductDetail? =
    if (id == null
        || name.isNullOrBlank()
        || unitPrice == null
        || stock == null
        || image.isNullOrBlank()
        || description.isNullOrBlank()
    ) {
        null
    } else {
        ProductDetail(id, name, unitPrice, stock, image, description)
    }
