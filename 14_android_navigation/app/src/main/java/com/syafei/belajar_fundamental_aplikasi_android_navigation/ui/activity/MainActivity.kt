package com.syafei.belajar_fundamental_aplikasi_android_navigation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.belajar_fundamental_aplikasi_android_navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}