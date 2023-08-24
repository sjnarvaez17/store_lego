package com.example.storelego.presentation.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.storelego.R
import com.example.storelego.databinding.ActivityProductDetailBinding
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.domain.use_case.Failure
import com.example.storelego.presentation.BaseActivity
import com.example.storelego.presentation.activity.ProductListActivity.Companion.KEY_ID
import com.example.storelego.presentation.viewmodel.ProductDetailViewModel
import javax.inject.Inject

class ProductDetailActivity: BaseActivity() {

    @Inject
    lateinit var viewModel: ProductDetailViewModel

    private lateinit var binding: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val productId = intent.getStringExtra(KEY_ID)
        if (productId.isNullOrBlank()) {
            finish()
        } else {
            viewModel.getProductDetail(productId)
            showIndeterminateModalDialog()
        }
    }

    private fun updateUI(productDetail: ProductDetail) {
        title = productDetail.name
        Glide.with(this@ProductDetailActivity)
            .load(productDetail.image)
            //.into(findViewById(R.id.productImage))
            .into(binding.productImage)

        binding.productName.text = productDetail.name
        binding.productPrice.text = productDetail.unitPrice.toString()
        binding.productStock.text = productDetail.stock.toString()
        binding.productDescription.text = productDetail.description

    }

}
