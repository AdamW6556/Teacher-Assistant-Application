package com.example.projektnr1.Model.Dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projektnr1.Model.Kurs

@Dao
interface KursDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(kurs: Kurs)

    @Update
    suspend fun update(kurs: Kurs)

    @Delete
    suspend fun delete(kurs: Kurs)

    @Query("DELETE FROM tab_kurs")
    suspend fun deleteAll()

    @Query("SELECT * FROM tab_kurs ORDER BY Idkurs ASC")
    fun kursyall(): LiveData<List<Kurs>>
}