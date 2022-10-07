package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ItemMyrecyclerviewBinding
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.data.Hero

class ListHeroAdapter(private val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_myrecyclerview, parent, false)
//        return ListViewHolder(view)

        val binding =
            ItemMyrecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        Glide.with(holder.itemView.context)
            .load(photo)
            .circleCrop()
            .into(holder.binding.imgItemPhoto)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listHero.size
}