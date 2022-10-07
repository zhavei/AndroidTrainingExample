package com.syafei.mysettingpreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafei.mysettingpreference.databinding.ActivityMainBinding
import com.syafei.mysettingpreference.ui.MyPreferenceFragment

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.setting_holder, MyPreferenceFragment())
            .commit()

    }
}