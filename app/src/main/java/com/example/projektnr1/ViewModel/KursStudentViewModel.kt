package com.example.projektnr1.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.Repositories.RepozytoriumStudentKurs

class KursStudentViewModel(application: Application): AndroidViewModel(application) {

    lateinit var kursystudenta: LiveData<List<Kurs>>
    lateinit var listast : List<Int>
    private var repokursstudent: RepozytoriumStudentKurs

    init {
        val studentGroupDao = MyDatabase.getDatabase(application).studentkursDao()
        repokursstudent = RepozytoriumStudentKurs(studentGroupDao)
    }

    fun kursstudentow(studentId: Int) {
        kursystudenta = repokursstudent.kursystudent(studentId)
    }

    fun usun(studentID: Int, courseID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repokursstudent.usun(studentID, courseID)
        }
    }

    fun postudencieid(studentID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            listast = repokursstudent.postudentid(studentID)
        }
    }

}