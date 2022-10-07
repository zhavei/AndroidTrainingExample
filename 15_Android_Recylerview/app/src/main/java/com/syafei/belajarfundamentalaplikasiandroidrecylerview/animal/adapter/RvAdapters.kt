package com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.R
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.data.Hewan

class RvAdapters() : RecyclerView.Adapter<AnimalViewHolder>() {

    private val hewan: MutableList<Hewan> = mutableListOf()

    fun addList(list: List<Hewan>) {
        hewan.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val itemAnimal = hewan[position]
        holder.bind(itemAnimal)
    }

    override fun getItemCount(): Int {
        return hewan.size
    }

}