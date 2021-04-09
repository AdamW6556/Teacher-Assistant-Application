package com.example.projektnr1.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tab_ocena",
    foreignKeys = [
        ForeignKey(
            entity = Student::class,
            parentColumns = ["Idstudent"],
            childColumns = ["idstudent"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Kurs::class,
            parentColumns = ["Idkurs"],
            childColumns = ["idkurs"],
            onDelete = CASCADE
        )
    ]
)
data class Ocena(@PrimaryKey(autoGenerate = true) var id: Int, var idstudent: Int, var idkurs: Int, var kursinfo: String, var ocena: Double, var opis: String, var data: Date)