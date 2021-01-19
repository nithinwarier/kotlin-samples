package com.androidians.roomsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidians.roomsample.entities.School
import com.androidians.roomsample.entities.Student
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao
        val schools = listOf(
            School("Google School"),
            School("Kotlin School"),
            School("Android School")
        )
        val students = listOf(
            Student("Beff Jezos", 2, "Kotlin School"),
            Student("Sundar Pichai", 5, "Google School"),
            Student("Uncle Tom", 8, "Kotlin School"),
            Student("Romain guy", 1, "Kotlin School"),
            Student("Andy Rubin", 2, "Android School")
        )
        lifecycleScope.launch {
            schools.forEach { dao.insertSchool(it) }
            students.forEach { dao.insertStudent(it) }

            val schoolWithStudents = dao.getSchoolWithStudents("Kotlin School")
            for (schStud in schoolWithStudents) {
                Log.e("MainAct", "schoolName: ${schStud.school.schoolName}")
                for (stud in schStud.students) {
                    Log.e("MainAct", "studentName: ${stud.studentName}")
                }
            }
        }

    }
}