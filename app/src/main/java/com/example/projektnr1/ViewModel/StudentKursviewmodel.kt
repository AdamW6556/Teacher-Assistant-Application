package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.Student
import com.example.projektnr1.Model.StudentKurs
import com.example.projektnr1.Model.Repositories.RepozytoriumStudentKurs

class StudentKursviewmodel(application: Application):AndroidViewModel(application) {

    lateinit var kursstudent: LiveData<List<Student>>
    lateinit var listelement : List<Int>
    private val repostudentkurs: RepozytoriumStudentKurs

    init {
        val studentkursDao = MyDatabase.getDatabase(application).studentkursDao()
        repostudentkurs = RepozytoriumStudentKurs(studentkursDao)
    }

    fun studencizkursu(idkurs: Int) {
        kursstudent = repostudentkurs.studentinkurs(idkurs)
    }

    fun usun(studentID: Int, courseID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repostudentkurs.usun(studentID, courseID)
        }
    }

    fun pokursieid(courseID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            listelement = repostudentkurs.pokursid(courseID)
        }
    }
}