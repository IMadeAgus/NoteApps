package com.example.mynoteapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//NoteRoomDatabase. Kelas ini akan digunakan untuk menginisialisasi database dalam aplikasi.
// Setelah terbentuk, tambahkan implementasi RoomDatabase, tambahkan annotation @Database dan ubah menjadi abstract class
@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    //Setelah itu tambahkan kode berikut untuk membuat variabel global berupa Singleton untuk Dao yang nanti akan dipanggil di kelas repository.
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): NoteRoomDatabase {
            if (INSTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    NoteRoomDatabase::class.java, "note_database")
                    .build()
                    //Kode di atas digunakan untuk membuat atau membangun database pada aplikasi dengan nama note_database.
                // Dengan begitu, Anda bisa memanfaatkannya untuk digunakan di kelas lain, pada project ini Anda memakainya di kelas NoteRepository.
                }
            }
            return INSTANCE as NoteRoomDatabase
        }
    }
}
//Anda sudah membuat beberapa kelas yang berfungsi sebagai komponen dari Room yaitu entitas, dao, dan database.
// Selanjutnya buat package baru dengan nama repository, dan buat kelas di dalamnya dengan nama NoteRepository.
// Kelas ini berfungsi sebagai penghubung antara ViewModel dengan database atau resource data.