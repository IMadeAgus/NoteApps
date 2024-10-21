package com.example.mynoteapps.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


//Oke, proses layouting sudah dilakukan. Sebelum melangkah lebih lanjut, buatlah package baru dengan nama helper.
// Package ini akan kita isi dengan beberapa kelas untuk membuat kode Anda menjadi lebih mudah.
// Pertama buatlah kelas di dalamnya dengan nama DateHelper. Kelas ini berfungsi untuk mendapatkan waktu seperti tanggal, bulan, tahun, dan jam.

object DateHelper {
    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }
}