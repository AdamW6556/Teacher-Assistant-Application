package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.Repositories.RepozytoriumKurs

class Kursviewmodel(application: Application):AndroidViewModel(application)  {

    val kursyall: LiveData<List<Kurs>>

    private val repokurs: RepozytoriumKurs

    init {
        val kursDao = MyDatabase.getDatabase(
            application
        ).kursDao()
        repokurs = RepozytoriumKurs(kursDao)
        kursyall = repokurs.wyswietl
    }

    fun dodajkurs(kurs: Kurs){
        viewModelScope.launch(Dispatchers.IO) {
            repokurs.dodaj(kurs)
        }
    }

    fun edytujkurs(kurs: Kurs){
        viewModelScope.launch(Dispatchers.IO) {
            repokurs.edytuj(kurs)
        }
    }

    fun usunkurs(kurs: Kurs){
        viewModelScope.launch(Dispatchers.IO) {
            repokurs.usun(kurs)
        }
    }

}