package com.example.projektnr1.Model
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "tab_kurs")
    data class Kurs(@PrimaryKey(autoGenerate = true) val Idkurs: Int, val nazwa: String)


