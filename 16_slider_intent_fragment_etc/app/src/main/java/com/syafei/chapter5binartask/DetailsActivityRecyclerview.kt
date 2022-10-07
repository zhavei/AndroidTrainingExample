package com.syafei.chapter5binartask

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.syafei.chapter5binartask.adapters.RecyclerFragmentAdapter
import com.syafei.chapter5binartask.databinding.ActivityRecyclerviewDetailsBinding

class DetailsActivityRecyclerview : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerviewDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receiveBundle()

    }

    private fun receiveBundle() {
        val bundle = intent?.extras
        val itemKode = bundle?.getString(RecyclerFragmentAdapter.CODE)
        val itemkategori = bundle?.getString(RecyclerFragmentAdapter.CATEGORY)
        val itemKonten = bundle?.getString(RecyclerFragmentAdapter.CONTENT)

        binding.apply {
            detailKodePertanyaan.text = itemKode
            detailKetegori.text = itemkategori
            detailIsiPertanyaan.text = itemKonten
        }

        //set actionbar title
        supportActionBar?.title = itemkategori
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "DetailsActivityRecyclerview started", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "DetailsActivityRecyclerview destroyed", Toast.LENGTH_SHORT).show()
        finish()
    }

}
