package com.example.projektnr1.Model.Dao
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projektnr1.Model.Kurs
import com.example.projektnr1.Model.Student
import com.example.projektnr1.Model.StudentKurs

@Dao
interface StudentKursDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(studentKurs: StudentKurs)

    @Query("SELECT * FROM tab_student_kurs join tab_student on tab_student_kurs.idstudent = tab_student.Idstudent WHERE idkurs = :kursID")
    fun studentinkurs(kursID: Int): LiveData<List<Student>>

    @Query("SELECT * FROM tab_student_kurs join tab_kurs on tab_student_kurs.idkurs = tab_kurs.Idkurs WHERE idstudent = :studentID")
    fun  kursystudenta(studentID: Int): LiveData<List<Kurs>>



    @Query("DELETE FROM tab_student_kurs WHERE idstudent = :studentID AND idkurs = :kursID")
    suspend fun usunkurs(studentID: Int, kursID: Int)

    @Query("DELETE FROM tab_ocena WHERE idstudent = :studentID AND idkurs = :kursID")
    suspend fun usunoceny(studentID: Int, kursID: Int)


    @Query("SELECT idstudent FROM tab_student_kurs  WHERE idkurs = :kursID")
    suspend fun pokursid(kursID: Int): List<Int>

    @Query("SELECT idkurs FROM tab_student_kurs  WHERE idstudent = :studentID")
    suspend fun postudentid(studentID: Int): List<Int>
}