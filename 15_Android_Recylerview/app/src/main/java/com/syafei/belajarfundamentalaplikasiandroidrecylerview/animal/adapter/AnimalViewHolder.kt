package com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.data.Hewan
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ItemRecyclerviewBinding

class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(animal: Hewan) = ItemRecyclerviewBinding.bind(itemView).run {

        ivAnimal.setImageResource(animal.images)
        tvNama.text = animal.names
        tvGender.text = animal.age.toString()
        tvFood.text = animal.food

    }

}