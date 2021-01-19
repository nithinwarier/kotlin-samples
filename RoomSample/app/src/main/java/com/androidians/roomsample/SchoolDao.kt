package com.androidians.roomsample

import androidx.room.*
import com.androidians.roomsample.entities.School
import com.androidians.roomsample.entities.SchoolWithStudents
import com.androidians.roomsample.entities.Student

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM School WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String) : List<SchoolWithStudents>

}