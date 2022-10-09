package com.syafei.roomapptraining1.database

import androidx.room.*


@Dao
interface BookDao {

    @Insert
    suspend fun insert(book: Book)

    @Query("SELECT * FROM book_table")
    fun getAllBooks(): List<Book>

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun delete(book: Book)

}