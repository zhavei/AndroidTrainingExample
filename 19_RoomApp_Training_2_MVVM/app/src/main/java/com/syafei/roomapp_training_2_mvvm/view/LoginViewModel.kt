package com.syafei.roomapp_training_2_mvvm.view

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.syafei.roomapp_training_2_mvvm.model.local.LoginTableModel
import com.syafei.roomapp_training_2_mvvm.repository.LoginRepository

class LoginViewModel : ViewModel() {

    var liveDataLogin: LiveData<LoginTableModel>? = null

    fun insertData(context: Context, userName: String, password: String) {
        LoginRepository.insertData(context, userName, password)
    }

    fun getLoginDetails(context: Context, userName: String): LiveData<LoginTableModel>? {

        liveDataLogin = LoginRepository.getLoginDetails(context, userName)
        return liveDataLogin

    }
}