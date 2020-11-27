package com.androidians.flows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flow = flow {
            for (i in 1..10) {
                emit("Hello world")
                delay(1000)
            }
        }

        val flow1 = flow {
            for (i in 1..10) {
                emit(i)
                delay(1000)
            }
        }

        GlobalScope.launch {
            flow1.buffer().filter {
                    it % 2 == 0
                }.map {
                    it * it
                }.collect {
                    Log.d("mainActivity", "output from consumer $it")
                    delay(2000)
                }
            }
        }
}
