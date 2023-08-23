package com.example.storelego.data.model

import android.os.Parcelable
import com.example.storelego.domain.model.Product
import com.example.storelego.domain.model.ProductDetail
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetailResponse(val id: Int?,
                                 val name: String?,
                                 val unitPrice: Int?,
                                 val stock: Int?,
                                 val image: String?,
                                 val description: String?): Parcelable


fun ProductDetailResponse.toProductDetail(): ProductDetail? =
    if (id==null || name.isNullOrBlank() || unitPrice==null || stock==null || image.isNullOrBlank() || description.isNullOrBlank()) {
        null
    } else {
        ProductDetail(id, name, unitPrice, stock, image, description)
    }