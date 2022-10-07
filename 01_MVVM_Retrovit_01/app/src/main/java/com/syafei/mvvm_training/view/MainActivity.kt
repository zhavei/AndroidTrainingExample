package com.syafei.mvvm_training.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.syafei.mvvm_training.data.network.RetrofitService
import com.syafei.mvvm_training.databinding.ActivityMainBinding
import com.syafei.mvvm_training.helper.ViewModelFactory
import com.syafei.mvvm_training.repository.MainRepository

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var viewModel: MainViewModel
    private val adapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.recyclerview.adapter = adapter

        viewModel =
            ViewModelProvider(this, ViewModelFactory(mainRepository))
                .get(MainViewModel::class.java)

        viewModel.movieList.observe(this) {
            adapter.setMovies(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()

    }
}