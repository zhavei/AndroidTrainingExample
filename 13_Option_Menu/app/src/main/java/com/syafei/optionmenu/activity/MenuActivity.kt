package com.syafei.optionmenu.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.optionmenu.databinding.ActivityMenuBinding
import org.json.JSONObject

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}