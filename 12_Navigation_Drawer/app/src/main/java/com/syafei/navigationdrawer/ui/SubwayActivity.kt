package com.syafei.navigationdrawer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.navigationdrawer.databinding.ActivitySubwayBinding

class SubwayActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubwayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubwayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar?.setDisplayHomeAsUpEnabled(true)


    }
}