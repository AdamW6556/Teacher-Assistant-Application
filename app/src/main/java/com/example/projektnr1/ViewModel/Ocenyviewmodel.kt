package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.Repositories.RepozytoriumOcena

class Ocenyviewmodel(application: Application):AndroidViewModel(application)  {

lateinit var ocenyall: LiveData<List<Ocena>>


    private var ocenarepo: RepozytoriumOcena

    init {

        val ocenaDao = MyDatabase.getDatabase(application).ocenaDao()

        ocenarepo = RepozytoriumOcena(ocenaDao)

    }

    fun ocenystudent(idstudent: Int, idkurs: Int) {

        ocenyall= ocenarepo.ocenystudentall(idstudent, idkurs)

    }

    fun usunocene(ocena: Ocena) {

        viewModelScope.launch {

            ocenarepo.usun(ocena)
        }
    }

    fun dodajocene(ocena: Ocena) {

        viewModelScope.launch {

            ocenarepo.dodaj(ocena)

        }
    }
}