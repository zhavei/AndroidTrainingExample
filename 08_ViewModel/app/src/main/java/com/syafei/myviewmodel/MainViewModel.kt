package com.syafei.myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var result = 0

    fun calculate(width: String, heigt: String, length: String){
        result = width.toInt() * heigt.toInt() * length.toInt()
    }
}