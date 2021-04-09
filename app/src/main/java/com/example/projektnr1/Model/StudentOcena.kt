package com.example.projektnr1.Model

import androidx.room.Embedded

data class StudentOcena (@Embedded var student: Student, @Embedded var ocena: Ocena)