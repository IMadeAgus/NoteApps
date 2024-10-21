package com.example.mynoteapps.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.mynoteapps.database.Note
import com.example.mynoteapps.repository.NoteRepository

//Setelah membuat Activity, kita akan buat terlebih dahulu kelas ViewModel sebagai penghubung antara Activity dengan Repository.

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)
    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }
    fun update(note: Note) {
        mNoteRepository.update(note)
    }
    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}