package com.example.storelego.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.storelego.R
import com.example.storelego.domain.model.Product

class ProductAdapter(private var product: List<Product>, private val listener: ProductListener):
    RecyclerView.Adapter<ProductAdapter.ItemViewHolder>() {

    interface ProductListener {
        fun onProductClick(product: Product)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val adapterContainer =
            itemView.findViewById<ConstraintLayout>(R.id.adapterContainer)
        private val productName = itemView.findViewById<TextView>(R.id.productName)

        fun bind(product: Product, listener: ProductListener) {
            productName.text = product.name
            adapterContainer.setOnClickListener { listener.onProductClick(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ItemViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.product_adapter, parent, false)
    )


    override fun getItemCount(): Int = product.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(product[position], listener)


}