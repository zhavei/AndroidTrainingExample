package com.syafei.roomapptraining1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.syafei.roomapptraining1.database.Book
import com.syafei.roomapptraining1.database.BookDao
import com.syafei.roomapptraining1.database.BookDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var bookDao: BookDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext, BookDatabase::class.java, "book_database")
            .build()

        bookDao = db.bookDao()
        testDB()
    }

    private fun testDB(){
        lifecycleScope.launch(Dispatchers.IO){
            Log.i("My Tag", "inserting 3 books")
            bookDao.insert(Book(0, "buku banten", "orang jawa"))
            bookDao.insert(Book(0, "buku melayu", "orang sunda"))
            bookDao.insert(Book(0, "buku koteka", "orang papua"))
            bookDao.insert(Book(0, "buku betawi", "orang jakarta"))

            val books = bookDao.getAllBooks()
            Log.i("My Tag", "${books.size} books there")
            for (book in books) {
                Log.i("Mytage", "id: ${book.id}, name: ${book.name}, outhor: ${book.author}")
            }

            bookDao.updateBook(Book(1, "buku anuan", "au dh apaan"))
            bookDao.delete(Book(0, "buku banten", "orang jawa"))

        }

    }
}