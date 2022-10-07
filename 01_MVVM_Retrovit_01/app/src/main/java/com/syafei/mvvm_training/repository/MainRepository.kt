package com.syafei.mvvm_training.repository

import com.syafei.mvvm_training.data.model.Movie
import com.syafei.mvvm_training.data.network.NetworkState
import com.syafei.mvvm_training.data.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies(): NetworkState<List<Movie>> {

        val respone = retrofitService.getALlMovies()
        return if (respone.isSuccessful) {
            val responseBody = respone.body()
            if (responseBody != null) {
                NetworkState.Succes(responseBody)
            } else {
                NetworkState.Error(respone)
            }
        } else {
            NetworkState.Error(respone)
        }
    }
}