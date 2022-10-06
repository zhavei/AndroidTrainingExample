package com.syafei.restaurantreview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syafei.restaurantreview.databinding.ItemReviewBinding

class ReviewAdapter(private val listReview: List<String>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(var viewBinding: ItemReviewBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val binding = ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.viewBinding.tvItem.text = listReview[position]
    }

    override fun getItemCount(): Int = listReview.size

}