package com.syafei.chapter5binartask.activityBringData

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.SecondFragment
import com.syafei.chapter5binartask.databinding.ActivityDataIntentTwoBinding

class DataIntentActivityTwo : AppCompatActivity() {

    private var _binding: ActivityDataIntentTwoBinding? = null
    private lateinit var binding: ActivityDataIntentTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDataIntentTwoBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        val intent2 = intent.getStringExtra(SecondFragment.INTENT_KEY_1)
        val textReciver = "from second Fragment: $intent2"
        binding.tvActivityDataIntent2.text = textReciver

        println("coba test $intent2")
        Log.i("data ActivityIntent2", "$intent2")

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}