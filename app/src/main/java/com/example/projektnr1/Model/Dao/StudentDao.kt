package com.example.projektnr1.Model.Dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projektnr1.Model.Student

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("DELETE FROM tab_student")
    suspend fun deleteAll()

    @Query("SELECT * FROM tab_student ORDER BY Idstudent ASC")
    fun selectAll(): LiveData<List<Student>>
}