package com.androidians.roomsample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.androidians.roomsample.entities.School
import com.androidians.roomsample.entities.Student

@Database(
    entities = [
        School::class,
        Student::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context : Context) : SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }

    }
}