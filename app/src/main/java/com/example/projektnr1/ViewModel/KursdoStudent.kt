package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.StudentKurs
import com.example.projektnr1.Model.Repositories.RepozytoriumKurs
import com.example.projektnr1.Model.Repositories.RepozytoriumStudentKurs

class KursdoStudent(application: Application): AndroidViewModel(application)  {

    val kursyall: LiveData<List<Kurs>>
    var kursy : MutableList<StudentKurs> = mutableListOf()
    private val repostudentkurs: RepozytoriumStudentKurs
    private val repokurs: RepozytoriumKurs

    init {
        val studentkursDao = MyDatabase.getDatabase(application).studentkursDao()
        val kursDao = MyDatabase.getDatabase(application).kursDao()
        repostudentkurs = RepozytoriumStudentKurs(studentkursDao)
        repokurs = RepozytoriumKurs((kursDao))
        kursyall = kursDao.kursyall()
    }

    fun dodajkurs(idstudent: Int, idkurs: Int) {
        val studentCourse = StudentKurs(0, idstudent, idkurs)
        viewModelScope.launch {
            repostudentkurs.dodaj(studentCourse)
        }
    }
}