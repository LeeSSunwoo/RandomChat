package com.example.randomchat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    var msgList = arrayListOf<Msg>(
        Msg("안녕 민경이야!")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val msgAdapter = MsgListAdapter(this,  msgList)
        mainListView.adapter = msgAdapter
    }
}
