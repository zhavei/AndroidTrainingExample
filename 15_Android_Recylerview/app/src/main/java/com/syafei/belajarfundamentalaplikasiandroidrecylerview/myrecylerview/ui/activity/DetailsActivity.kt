package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ActivityDetailsBinding
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.data.Hero

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Hero>("DATA")

        binding.tvDetailsNameHero.text = data?.name
        binding.tvDetailsDeskription.text = data?.description
        Glide.with(this)
            .load(data?.photo)
            .circleCrop()
            .into(binding.ivDetails)

        Log.d("details data", data?.name.toString())

    }
}