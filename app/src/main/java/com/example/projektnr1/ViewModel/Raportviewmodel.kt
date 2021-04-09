package com.example.projektnr1.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import java.util.*
import com.example.projektnr1.Model.MyDatabase
import com.example.projektnr1.Model.StudentOcena
import com.example.projektnr1.Model.Repositories.RepozytoriumOcena

class Raportviewmodel(application: Application):AndroidViewModel(application)  {

    lateinit var ocenystudenta: LiveData<List<StudentOcena>>
    private var ocenarepo: RepozytoriumOcena

    init {
        val ocenaDao = MyDatabase.getDatabase(application).ocenaDao()
        ocenarepo = RepozytoriumOcena(ocenaDao)
    }

    fun ocenaidata(data: Date, data1: Date) {
        ocenystudenta = ocenarepo.ocenydataall(data,data1)
    }
}