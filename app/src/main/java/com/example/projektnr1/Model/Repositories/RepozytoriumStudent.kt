package com.example.projektnr1.Model.Repositories
import androidx.lifecycle.LiveData
import com.example.projektnr1.Model.Student
import com.example.projektnr1.Model.Dao.StudentDao


class RepozytoriumStudent(private val studentDao: StudentDao) {

    val wyswietl: LiveData<List<Student>> = studentDao.selectAll()

    suspend fun dodaj(student: Student){ studentDao.add(student) }

    suspend fun edytuj(student: Student){ studentDao.update(student) }

    suspend fun usun(student: Student){ studentDao.delete(student) }
}