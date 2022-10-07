package com.syafei.mvvm_training.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syafei.mvvm_training.data.model.Movie
import com.syafei.mvvm_training.databinding.ItemListMainadapterBinding
import com.syafei.mvvm_training.helper.ValidationUtil

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var movieList = mutableListOf<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    inner class MainViewHolder(private val binding: ItemListMainadapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            with(binding) {
                if (ValidationUtil.validateMovie(movie)) {
                    name.text = movie.name
                    Glide.with(binding.root.context).load(movie.imageUrl).into(imageview)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding =
            ItemListMainadapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}