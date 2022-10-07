package com.syafei.mvvm_training.helper

import com.syafei.mvvm_training.data.model.Movie

object ValidationUtil {

    fun validateMovie(movie: Movie): Boolean {

        if (movie.name.isNotEmpty() && movie.category.isNotEmpty()) {
            return true
        }
        return false
    }

}