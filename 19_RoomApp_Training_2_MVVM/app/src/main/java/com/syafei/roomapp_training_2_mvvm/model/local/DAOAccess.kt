package com.syafei.roomapp_training_2_mvvm.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAOAccess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(loginTableModel: LoginTableModel)

    @Query("SELECT * FROM Login WHERE username =:userName")
    fun getLoginDetails(userName: String?) : LiveData<LoginTableModel>

}