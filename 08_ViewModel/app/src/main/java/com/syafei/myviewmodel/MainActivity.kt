package com.syafei.myviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.syafei.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //myViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayReslut()


        binding.btnCalculate.setOnClickListener {

            val width = binding.edtWidth.text.toString()
            val heigt = binding.edtHeight.text.toString()
            val lengt = binding.edtLength.text.toString()

            when {
                width.isEmpty() -> {
                    binding.edtHeight.error = "cannot empty"
                }
                heigt.isEmpty() -> {
                    binding.edtHeight.error = "cannot empty"
                }
                lengt.isEmpty() -> {
                    binding.edtLength.error = "cannot empty"
                }
                else -> {
                    viewModel.calculate(width, heigt, lengt)
                    displayReslut()

                }
            }

        }


    }

    private fun displayReslut() {
        binding.tvResult.text = viewModel.result.toString()
    }
}