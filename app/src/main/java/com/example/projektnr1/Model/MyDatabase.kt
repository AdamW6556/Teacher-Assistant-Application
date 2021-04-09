package com.example.projektnr1.Model
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projektnr1.Model.Dao.KursDao
import com.example.projektnr1.Model.Dao.OcenaDao
import com.example.projektnr1.Model.Dao.StudentDao
import com.example.projektnr1.Model.Dao.StudentKursDao

@Database(entities = [Kurs::class, Student::class, Ocena::class, StudentKurs::class ], version = 4, exportSchema = false) @TypeConverters(DataTime::class)
abstract class MyDatabase:RoomDatabase() {


    abstract fun kursDao(): KursDao
    abstract fun studentDao(): StudentDao
    abstract fun ocenaDao(): OcenaDao
    abstract fun studentkursDao(): StudentKursDao



    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            else
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "my_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    return instance
                }
        }
    }
}