package com.example.projektnr1.Model.Repositories
import androidx.lifecycle.LiveData
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.Dao.KursDao

class RepozytoriumKurs(private var kursDao: KursDao) {

    val wyswietl: LiveData<List<Kurs>> = kursDao.kursyall()

    suspend fun dodaj(kurs: Kurs){ kursDao.add(kurs) }

    suspend fun edytuj(kurs: Kurs){ kursDao.update(kurs) }

    suspend fun usun(kurs: Kurs){ kursDao.delete(kurs) }
}