package com.syafei.mvvm_training.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syafei.mvvm_training.data.model.Movie
import com.syafei.mvvm_training.data.network.NetworkState
import com.syafei.mvvm_training.repository.MainRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    val movieList = MutableLiveData<List<Movie>>()
    var job: Job? = null
    val loading = MutableLiveData<Boolean>()

    private val exceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable -> onError("Exception handled: ${throwable.localizedMessage}") }

    fun getAllMovies() {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)

            when (val response = mainRepository.getAllMovies()) {
                is NetworkState.Succes -> {
                    movieList.postValue(response.data)
                    //loading.value = true //anu ini loading muter terus g tau logicnya gmn spy brenti
                }
                is NetworkState.Error -> {
                    if (response.response.code() == 401) {
                        //
                    } else {
                        //movieList.postValue(NetworkState.Error)
                    }
                }
            }
        }
    }

    private fun onError(message: String) {
        _errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}