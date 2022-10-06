package com.syafei.mvvm_training.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syafei.mvvm_training.repository.MainRepository
import com.syafei.mvvm_training.view.MainViewModel

class ViewModelFactory constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("viewModel not Found")
        }
    }

}