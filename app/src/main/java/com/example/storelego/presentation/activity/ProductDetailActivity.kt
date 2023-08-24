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
        appComponent.inject(this)

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
        val intProductId: Int = intent.getIntExtra(EXTRA_PRODUCT_ID, 0)
        val productId = intProductId.toString()

        viewModel.getProductDetail(productId)
        showIndeterminateModalDialog()
    }

    private fun updateUI(productDetail: ProductDetail) {
        hideIndeterminateModalDialog()
        title = productDetail.name

        with(binding) {
            Glide.with(this@ProductDetailActivity)
                .load(productDetail.image)
                .into(productImage)

            productName.text = productDetail.name
            productPrice.text = productDetail.unitPrice.toString()
            productStock.text = productDetail.stock.toString()
            productDescription.text = productDetail.description
        }
    }
}
