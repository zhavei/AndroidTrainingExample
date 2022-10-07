package com.syafei.mvvm_training.data.network

import retrofit2.Response


sealed class NetworkState<out T> {
    data class Succes<out T>(val data: T) : NetworkState<T>()
    data class Error<T>(val response: Response<T>) : NetworkState<T>()
}

fun <T> Response<T>.parseResponse(): NetworkState<T> {
    return if (this.isSuccessful && this.body() != null) {
        val responseBody = this.body()
        NetworkState.Succes(responseBody!!)
    } else {
        NetworkState.Error(this)
    }
}
