package com.syafei.roomapptraining1.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "book_table")
data class Book(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var name: String,

    @ColumnInfo(name = "published_author")
    var author: String,

)