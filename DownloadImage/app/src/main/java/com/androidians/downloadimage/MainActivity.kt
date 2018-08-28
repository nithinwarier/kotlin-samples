package com.androidians.downloadimage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainLayout = findViewById<LinearLayout>(R.id.main_layout)
        val imgView = ImageView(this)
        Glide.with(this).load("https://s3.amazonaws.com/appsdeveloperblog/Micky.jpg").into(imgView)
        mainLayout.addView(imgView)
    }
}
