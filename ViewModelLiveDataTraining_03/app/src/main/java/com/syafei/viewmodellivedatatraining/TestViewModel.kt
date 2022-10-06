package com.syafei.viewmodellivedatatraining

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    var number = 0

    private val _currentNUmber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val currentNUmber: MutableLiveData<Int> = _currentNUmber

    private val _currentBol: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val curretBol: MutableLiveData<Boolean> = _currentBol


}