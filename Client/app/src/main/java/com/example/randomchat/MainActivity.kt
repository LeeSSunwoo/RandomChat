package com.example.randomchat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var StartBtn = findViewById<Button>(R.id.StartButton)

        StartBtn.setOnClickListener(View.OnClickListener {

        })

    }
}
