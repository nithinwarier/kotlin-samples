package com.androidians.navigatetosecond

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_next).setOnClickListener(View.OnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        })
    }
}
