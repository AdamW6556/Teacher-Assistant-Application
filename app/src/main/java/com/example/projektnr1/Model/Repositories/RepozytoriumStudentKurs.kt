package com.example.projektnr1.Model.Repositories
import androidx.lifecycle.LiveData
import com.example.projektnr1.Model.Student
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.StudentKurs
import com.example.projektnr1.Model.Dao.StudentKursDao

class RepozytoriumStudentKurs(private val studentKursDao: StudentKursDao) {

    suspend fun dodaj(studentKurs: StudentKurs) {
        studentKursDao.add(studentKurs)
    }


    suspend fun usun(idstudent: Int, idkurs: Int) {
        studentKursDao.usunkurs(idstudent, idkurs)
        studentKursDao.usunoceny(idstudent, idkurs)
    }


    suspend fun pokursid(courseId: Int): List<Int> {
        return studentKursDao.pokursid(courseId)
    }



    suspend fun postudentid(studentId: Int): List<Int> {
        return studentKursDao.postudentid(studentId)
    }



    fun studentinkurs(courseId: Int): LiveData<List<Student>> {
        return studentKursDao.studentinkurs(courseId)
    }

    fun kursystudent(studentId: Int): LiveData<List<Kurs>> {
        return studentKursDao.kursystudenta(studentId)
    }


}