package com.syafei.chapter5binartask.activityBringData

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.syafei.chapter5binartask.SecondFragment
import com.syafei.chapter5binartask.databinding.ActivityDataIntentTreeBinding
import com.syafei.chapter5binartask.models.Cars

class DataIntentActivityTree : AppCompatActivity() {

    private var _binding: ActivityDataIntentTreeBinding? = null
    lateinit var binding: ActivityDataIntentTreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDataIntentTreeBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        val receiveParcelable = intent.getParcelableExtra<Cars>(SecondFragment.INTENT_KEY_1) as Cars
        binding.tvActivityDataIntent3.text = receiveParcelable.merk
        binding.tvActivityDataIntent32.text = receiveParcelable.tipe

        Glide.with(this)
            .load(receiveParcelable.display)
            .into(binding.ivActivityDataIntent3)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}