package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.Student
import com.example.projektnr1.Model.Repositories.RepozytoriumStudent

class Studentviewmodel(application: Application):AndroidViewModel(application)  {

    val studenci: LiveData<List<Student>>
    private val repostudent: RepozytoriumStudent

    init {
        val studentDao = MyDatabase.getDatabase(
            application
        ).studentDao()
        repostudent = RepozytoriumStudent(studentDao)
        studenci = repostudent.wyswietl
    }

    fun dodajstudenta(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repostudent.dodaj(student)
        }
    }

    fun edytujstudenta(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repostudent.edytuj(student)
        }
    }

    fun usunstudenta(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repostudent.usun(student)
        }
    }

}