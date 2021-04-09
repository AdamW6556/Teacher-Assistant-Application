package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.Student
import com.example.projektnr1.Model.StudentKurs
import com.example.projektnr1.Model.Repositories.RepozytoriumStudentKurs
import com.example.projektnr1.Model.Repositories.RepozytoriumStudent

class StudentdoKursu(application: Application): AndroidViewModel(application)  {


    val studenciall: LiveData<List<Student>>

    var studenci : MutableList<StudentKurs> = mutableListOf()

    private val repostudentkurs: RepozytoriumStudentKurs

    private val repostudent: RepozytoriumStudent

    init {
        val studentkursDao = MyDatabase.getDatabase(application).studentkursDao()

        val studentDao = MyDatabase.getDatabase(application).studentDao()

        repostudentkurs = RepozytoriumStudentKurs(studentkursDao)

        repostudent = RepozytoriumStudent((studentDao))

        studenciall = studentDao.selectAll()
    }

    fun dodajstudenta(idstudent: Int, idkurs: Int) {

        val studentkurs = StudentKurs(0, idstudent, idkurs)

        viewModelScope.launch {

            repostudentkurs.dodaj(studentkurs)
        }
    }

}