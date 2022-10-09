package com.syafei.roomapp_training_2_mvvm.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Login")
data class LoginTableModel(

    @ColumnInfo(name = "username")
    val userName: String,

    @ColumnInfo(name = "password")
    val password: String,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
