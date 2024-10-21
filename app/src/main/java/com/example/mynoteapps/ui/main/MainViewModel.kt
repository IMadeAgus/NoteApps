package com.example.mynoteapps.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mynoteapps.database.Note
import com.example.mynoteapps.repository.NoteRepository

class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
    //Dengan memanggil getAllNotes(), Activity dengan mudah meng-observe data list notes dan bisa segera ditampilkan.
}
//Bagian kelas ViewModel jadi lebih singkat, hanya menginisialisasi kelas Repository dan mengambil fungsi yang ada pada kelas tersebut.