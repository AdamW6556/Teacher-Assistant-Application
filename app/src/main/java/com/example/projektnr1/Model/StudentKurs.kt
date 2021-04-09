package com.example.projektnr1.Model
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "tab_student_kurs",
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

data class StudentKurs (@PrimaryKey(autoGenerate = true) val id:Int, val idstudent: Int, val idkurs: Int)
