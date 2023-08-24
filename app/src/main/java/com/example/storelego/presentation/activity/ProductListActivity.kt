package com.example.storelego.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.storelego.databinding.ActivityProductBinding
import com.example.storelego.domain.model.Product
import com.example.storelego.presentation.BaseActivity
import com.example.storelego.presentation.activity.ProductDetailActivity.Companion.KEY_ID
import com.example.storelego.presentation.adapter.ProductAdapter
import com.example.storelego.presentation.viewmodel.ProductListViewModel
import javax.inject.Inject

class ProductListActivity : BaseActivity(), ProductAdapter.ProductListener {


    private lateinit var binding: ActivityProductBinding
    private lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var viewModel: ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        binding = ActivityProductBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapterLayoutManager = LinearLayoutManager(this)
        productAdapter = ProductAdapter(emptyList(), this)
        binding.recycler.apply {
            layoutManager = adapterLayoutManager
            adapter = productAdapter
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.productList.observe(this) {
            // Hacer algo cuando se reciba una lista de productos
            it.forEach { product ->
                println(product.toString())

            }
        }

        viewModel.error.observe(this) {
            onFailure(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getProductList()
    }

    override fun onProductClick(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
            .apply { putExtra(KEY_ID, product.id) }
        startActivity(intent)
    }

    private fun onResponse(productList: List<Product>) {
        hideIndeterminateModalDialog()
        productAdapter.updateContent(productList)
    }

}
