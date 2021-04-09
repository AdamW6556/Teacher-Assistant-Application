package com.example.projektnr1.Model
import androidx.room.TypeConverter
import java.util.*

class DataTime
{
    @TypeConverter

    fun dataToUnix(data: Date): Long {

        return data.time
    }


    @TypeConverter

    fun unixToData(x: Long): Date {

        return Date(x)
    }


}