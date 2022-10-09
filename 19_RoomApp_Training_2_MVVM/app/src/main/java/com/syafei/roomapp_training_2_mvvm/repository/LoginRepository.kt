package com.syafei.roomapp_training_2_mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.syafei.roomapp_training_2_mvvm.model.local.LoginDatabase
import com.syafei.roomapp_training_2_mvvm.model.local.LoginTableModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LoginRepository {

    companion object {
        var loginDatabase: LoginDatabase? = null
        var loginTableModel: LiveData<LoginTableModel>? = null

        fun initializeDB(context: Context): LoginDatabase {
            return LoginDatabase.getDatabaseClient(context)
        }

        fun insertData(
            context: Context,
            userName: String,
            password: String
        ) {
            loginDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val loginDetails = LoginTableModel(userName, password)
                loginDatabase!!.loginDao().insertData(loginDetails)

            }
        }

        fun getLoginDetails(context: Context, userName: String): LiveData<LoginTableModel>? {

            loginDatabase = initializeDB(context)
            loginTableModel = loginDatabase?.loginDao()?.getLoginDetails(userName)
            return loginTableModel

        }
    }
}