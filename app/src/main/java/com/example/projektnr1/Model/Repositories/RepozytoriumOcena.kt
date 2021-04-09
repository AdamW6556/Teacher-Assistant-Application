package com.example.projektnr1.Model.Repositories
import java.util.*
import androidx.lifecycle.LiveData
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.Model.Dao.OcenaDao
import com.example.projektnr1.Model.StudentOcena

class RepozytoriumOcena(private val ocenaDao: OcenaDao)
{
    suspend fun dodaj(ocena: Ocena)
    {
        ocenaDao.add(ocena)
    }

    suspend fun usun(ocena: Ocena)
    {
        ocenaDao.delete(ocena)
    }

    fun ocenystudentall(studentId: Int, kursid: Int): LiveData<List<Ocena>> {
        return ocenaDao.ocenystudent(studentId, kursid)
    }

    fun ocenydataall(first: Date, second: Date): LiveData<List<StudentOcena>> {
        return ocenaDao.dataocen(first, second)
    }

}