package com.example.storelego.presentation.activity

import android.os.Bundle
import com.example.storelego.databinding.ActivityProductBinding
import com.example.storelego.domain.model.Product
import com.example.storelego.presentation.BaseActivity
import com.example.storelego.presentation.adapter.ProductAdapter
import com.example.storelego.presentation.viewmodel.ProductListViewModel
import javax.inject.Inject

class ProductListActivity : BaseActivity(), ProductAdapter.ItemAdapterListener {

    private lateinit var binding: ActivityProductBinding
    private var productAdapter: ProductAdapter? = null

    @Inject
    lateinit var viewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        binding = ActivityProductBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        viewModel.productList.observe(this) {
            onContent(it)
        }

        viewModel.error.observe(this) {
            onFailure(it)
        }
    }

    override fun onResume() {
        super.onResume()
        initializeAdapter()
        viewModel.getProductList()
    }

    private fun onContent(productList: List<Product>) {
        initializeAdapter()
        hideIndeterminateModalDialog()
        productAdapter?.submitList(productList)
    }

    override fun onProductClicked(product: Product) {
        startActivity(
            ProductDetailActivity.getIntent(this, product.id)
        )
    }

    private fun initializeAdapter() {
        if (productAdapter == null) {
            productAdapter = ProductAdapter(this)
            binding.recycler.adapter = productAdapter
        }
    }
}
