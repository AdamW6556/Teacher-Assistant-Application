package com.example.projektnr1.Model.Dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projektnr1.Model.Ocena
import com.example.projektnr1.Model.StudentOcena
import java.util.*


@Dao
interface OcenaDao {
    @Insert
    suspend fun add(ocena: Ocena)

    @Delete
    suspend fun delete(ocena: Ocena)

    @Query("DELETE FROM tab_ocena")
    suspend fun deleteAll()

    @Query("SELECT * FROM tab_ocena WHERE idstudent = :idstudenta and idkurs = :idkursu")
    fun ocenystudent(idstudenta: Int, idkursu: Int): LiveData<List<Ocena>>

    @Query("SELECT * FROM tab_student JOIN tab_ocena on tab_ocena.idstudent = tab_student.Idstudent WHERE data > :first AND data < :second")
    fun dataocen(first: Date, second: Date): LiveData<List<StudentOcena>>
}