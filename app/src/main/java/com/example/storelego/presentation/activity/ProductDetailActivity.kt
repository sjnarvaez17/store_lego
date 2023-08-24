package com.example.storelego.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.storelego.R
import com.example.storelego.databinding.ActivityProductDetailBinding
import com.example.storelego.domain.model.ProductDetail
import com.example.storelego.presentation.BaseActivity
import com.example.storelego.presentation.viewmodel.ProductDetailViewModel
import javax.inject.Inject

class ProductDetailActivity : BaseActivity() {

    companion object {
        private const val EXTRA_PRODUCT_ID = "productId"

        fun getIntent(context: Context, productId: Int) =
            Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(EXTRA_PRODUCT_ID, productId)
            }
    }

    private lateinit var binding: ActivityProductDetailBinding

    @Inject
    lateinit var viewModel: ProductDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()

        viewModel.productDetail.observe(this) {
            updateUI(it)
        }

        viewModel.error.observe(this) {
            onFailure(it)
        }
    }

    override fun onResume() {
        super.onResume()
        val productId = intent.getStringExtra(EXTRA_PRODUCT_ID).orEmpty()

        viewModel.getProductDetail(productId)
        showIndeterminateModalDialog()
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
