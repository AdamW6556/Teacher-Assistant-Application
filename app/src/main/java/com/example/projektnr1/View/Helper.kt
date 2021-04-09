package com.example.projektnr1.View
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.Model.Student
import java.util.*

class Helper {

    companion object
    {
        var ocenabiez: Ocena = Ocena(0, 0,0, "", 0.0,"",  Date())

        var studentbiez: Student = Student(0,"","")

        var kursbiez: Kurs = Kurs(0,"")



        var databiez1 = Calendar.getInstance()

        var databiez2 = Calendar.getInstance()
    }

}