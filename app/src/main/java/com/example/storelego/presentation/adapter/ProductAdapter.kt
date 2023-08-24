package com.example.storelego.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storelego.databinding.ProductAdapterBinding
import com.example.storelego.domain.model.Product

class ProductAdapter(
    private val listener: ItemAdapterListener
) : ListAdapter<Product, ProductAdapter.ItemViewHolder>(
    DiffCallback()
) {

    private class DiffCallback : DiffUtil.ItemCallback<Product>() {

        override fun areItemsTheSame(oldItem: Product, newItem: Product) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Product, newItem: Product) = oldItem == newItem
    }

    interface ItemAdapterListener {
        fun onProductClicked(product: Product)
    }

    class ItemViewHolder(private val binding: ProductAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product, listener: ItemAdapterListener) {
            val context = binding.root.context

            binding.productName.text = product.name

            Glide.with(context)
                .load(product.image)
                .into(binding.productImage)

            binding.root.setOnClickListener { listener.onProductClicked(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        ProductAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
        holder.bind(getItem(position), listener)
}