package com.example.mynoteapps.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

//Buatlah satu kelas interface di dalam package database dengan nama NoteDao.
// Kelas ini nantinya digunakan untuk melakukan eksekusi quiring.
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note: Note)
    //Menggunakan @Insert untuk query insert pada database sesuai dengan input entitas yang dimasukkan,
    // contohnya jika pada perintah di atas adalah Note. Sedangkan kode OnConflictStrategy.
    // IGNORE digunakan jika data yang dimasukkan sama, maka dibiarkan saja.

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * from note ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>
    //Selain itu, Anda juga bisa melakukan query atau menjalankan intruksi atau perintah untuk mengeksekusi sebuah aksi dengan anotasi @Query.
    // Contohnya kode di atas berfungsi untuk mendapatkan semua note dengan pengurutan berdasarkan id terkecil ke besar.
}
//Kode di atas digunakan untuk melakukan aksi CRUD(Create, Read, Update dan Delete).
// Sebuah kelas interface yang diberi sebuah annotation @dao akan menjadi sebuah kelas Dao secara otomatis.