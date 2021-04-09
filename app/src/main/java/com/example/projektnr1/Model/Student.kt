package com.example.projektnr1.Model
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tab_student")
    data class Student(@PrimaryKey(autoGenerate = true) val Idstudent: Int, val imie: String, val nazwisko: String)
