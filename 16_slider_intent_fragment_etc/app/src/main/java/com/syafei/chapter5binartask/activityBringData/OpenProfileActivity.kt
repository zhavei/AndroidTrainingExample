package com.syafei.chapter5binartask.activityBringData

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.databinding.ActivityOpenProfileBinding

class OpenProfileActivity: AppCompatActivity() {

    private lateinit var binding: ActivityOpenProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }

}