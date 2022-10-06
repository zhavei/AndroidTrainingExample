package com.syafei.roomsprojecttraining.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.syafei.roomsprojecttraining.R
import com.syafei.roomsprojecttraining.databinding.ActivityMainBinding
import com.syafei.roomsprojecttraining.helper.ViewModelFactory
import com.syafei.roomsprojecttraining.ui.insert.NoteAddUpdateActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = NoteAdapter()
        binding.rvNote.layoutManager = LinearLayoutManager(this)
        binding.rvNote.setHasFixedSize(true)
        binding.rvNote.adapter = adapter

        val mainViewModel = obtainViewModel(this@MainActivity)
        mainViewModel.getALlNotes().observe(this) { noteList ->
            if (noteList != null) {
                adapter.setListNote(noteList)
            }
        }

        binding.fabAdd.setOnClickListener { view ->
            if (view.id == R.id.fab_add) {
                val intent = Intent(this@MainActivity, NoteAddUpdateActivity::class.java)
                startActivity(intent)
            }
        }
    }


    private fun obtainViewModel(activity: AppCompatActivity): MainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[MainViewModel::class.java]

    }
}