package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.R
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ActivityMyrecyclerviewMainBinding
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.data.Hero
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.adapter.ListHeroAdapter
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.adapter.OnItemClickCallback

class MainMyRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyrecyclerviewMainBinding
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyrecyclerviewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rvHeroes = binding.rvMymainRv
        rvHeroes.setHasFixedSize(true)
        list.addAll(listHeroes)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        //on change orientation adapter behavior
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvHeroes.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvHeroes.layoutManager = LinearLayoutManager(this)
        }

        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallBack(object : OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
                sendIntent(data)
            }
        })
    }

    private fun sendIntent(dataHero: Hero) {
        val intent = Intent(this@MainMyRecyclerViewActivity, DetailsActivity::class.java)
        intent.putExtra("DATA", dataHero)
        startActivity(intent)
    }

    private val listHeroes: ArrayList<Hero>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val description = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listHero = ArrayList<Hero>()
            for (i in dataName.indices) {
                val hero = Hero(dataName[i], description[i], dataPhoto[i])
                listHero.add(hero)
            }
            return listHero
        }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "you selected ${hero.name}", Toast.LENGTH_SHORT).show()
    }
}