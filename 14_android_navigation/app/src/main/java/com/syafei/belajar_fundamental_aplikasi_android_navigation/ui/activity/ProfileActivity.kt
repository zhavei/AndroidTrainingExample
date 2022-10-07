package com.syafei.belajar_fundamental_aplikasi_android_navigation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.belajar_fundamental_aplikasi_android_navigation.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}