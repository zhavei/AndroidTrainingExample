package com.syafei.roomsprojecttraining.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.syafei.roomsprojecttraining.database.Note
import com.syafei.roomsprojecttraining.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getALlNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()

}