package com.syafei.belajarfundamentalaplikasiandroidrecylerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.adapter.RvAdapters
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.data.Hewan
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var hewanData: ArrayList<Hewan>
    private val animalAdapter = RvAdapters()

    private val animalDummy = listOf(
        Hewan(R.drawable.ic_baseline_1x_mobiledata_24, "bebek", 7, "dedeg"),
        Hewan(R.drawable.ic_baseline_3d_rotation_24, "uguk", 4, "daging"),
        Hewan(R.drawable.ic_baseline_accessibility_new_24, "emeng", 2, "ikan")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hewanData = ArrayList<Hewan>()
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvMain.layoutManager = linearLayoutManager
        binding.rvMain.adapter = animalAdapter
        /*binding.rvMain.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )*/

        animalAdapter.addList(animalDummy)

//        listAnimalAdd()
    }

     private fun listAnimalAdd() {
        hewanData.add(
            Hewan(R.drawable.ic_baseline_1x_mobiledata_24, "bebek", 9, "dedek"),
        )
        hewanData.add(Hewan(R.drawable.ic_baseline_3d_rotation_24, "guguk", 5, "daging"))
        hewanData.add(Hewan(R.drawable.ic_baseline_accessibility_new_24, "emeng", 3, "ikan"))
    }
}