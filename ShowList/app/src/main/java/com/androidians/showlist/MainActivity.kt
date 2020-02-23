package com.androidians.showlist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView);
        var adapter = UsersAdapter(generateData())
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.elevation = 10f

        recyclerView?.adapter = adapter 
    }

    private fun generateData() : ArrayList<User> {
        var result = ArrayList<User>()

        for (i in 0..9) {
            var user : User = User("Nithin", "nithin@gmail.com", 28)
            result.add(user)
        }

        return result;
    }

}
