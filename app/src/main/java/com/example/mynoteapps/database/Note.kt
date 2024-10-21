package com.example.mynoteapps.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize //Setelah itu, implementasikan Parcelable. Maka kelas Note akan menjadi seperti ini:
class Note (
    //Selanjutnya tambahkan beberapa variable berikut seperti id, title, description, dan date.
// Jangan lupa untuk menambahkan atribut pada variabel tersebut seperti ini:

    @PrimaryKey(autoGenerate = true)
    //@PrimaryKey digunakan untuk menjadikan sebuah column menjadi primary key. Sedangkan autoGenerate digunakan untuk membuat id secara otomatis.
    @ColumnInfo(name= "id")
    var id: Int = 0,
    //Kode @ColumnInfo digunakan untuk memberi nama column dari tabel. Jika tidak diberi nama, maka default dari nama column adalah variable tersebut.

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null
): Parcelable

//Kode di atas awalnya adalah sebuah data model Note. Akan tetapi,
// bisa dengan mudah menjadi sebuah table dalam Room dengan menambahkan annotation @Entity.
// Default dari nama tabel adalah sesuai dengan nama kelas tersebut. Kemudian variabel yang di dalamnya akan menjadi column dari tabel Note.