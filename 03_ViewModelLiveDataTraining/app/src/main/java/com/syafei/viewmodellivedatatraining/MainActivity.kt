package com.syafei.viewmodellivedatatraining

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.syafei.viewmodellivedatatraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val testViewModel: TestViewModel by viewModels()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        testViewModel.currentNUmber.observe(this) {
            binding.tvNumber.text = it.toString()
        }

        testViewModel.curretBol.observe(this) {

            binding.tvBoleean.text = it.toString()
        }

        incrementel()


    }

    private fun incrementel() {
        binding.btnIncrement.setOnClickListener {
            testViewModel.currentNUmber.value = ++testViewModel.number
            testViewModel.curretBol.value = testViewModel.number % 2 == 0
        }
    }
}


