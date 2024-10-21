package com.example.mynoteapps.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mynoteapps.database.Note
import com.example.mynoteapps.database.NoteDao
import com.example.mynoteapps.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    //Jika Anda perhatikan, NoteDao bisa langsung Anda gunakan dengan cara mendefinisikan RoomDatabase.
    }
    //Ini terjadi karena Dao atau Data Access Object akan secara otomatis terhubung dengan RoomDatabase, selama kelas tersebut sudah diberi annotation @Dao.
    // Jadi Anda bisa memakainya untuk menggunakanya ke kelas-kelas lain. Seperti untuk mendapatkan semua data Note:

    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()
    //Pada kelas ViewModel, Anda bisa mendapatkan list notes dengan cara memanggil metode getAllNotes(). Hal ini karena Anda menggunakan LiveData yang bersifat asynchronous.


    fun insert(note: Note) {
        executorService.execute{mNotesDao.insert(note)}
    }
    fun delete(note: Note) {
        executorService.execute { mNotesDao.delete(note) }
    }
    fun update(note: Note) {
        executorService.execute { mNotesDao.update(note) }
    }
    // Namun berbeda pada bagian insert, update dan delete, aksi tersebut harus dijalankan menggunakan ExecutorService.
    // Jika proses di atas hanya dilakukan tanpa executorService, maka akan terjadi force close.
    // Hal ini disebabkan karena proses insert, update dan delete menggunakan thread yang berbeda yakni background thread.
}