package com.example.randomchat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {

    var isRuning = false
    val ip = "10.120.73.216" // 192.168.0.0
    val port = 5000 // 여기에 port를 입력해주세요

    lateinit var socket :Socket
    lateinit var outStream :OutputStream // outputStream - 데이터를 내보내는 스트림입니다.
    lateinit var inStream :InputStream  // inputStream - 데이터를 받는 스트림입니다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {view ->
            Toast.makeText(this,"send", Toast.LENGTH_SHORT)
            val data = editText.text.toString() // 데이터는 byteArray로 변경 할 수 있어야 합니다.
            outStream.write(data.toByteArray()) // toByteArray() 파라미터로 charset를 설정할 수 있습니다. 기본값 utf-8
        }

        match.setOnClickListener {view ->
            Log.d("match test", "match button clicked")
            if(isRuning == false) {
                isRuning = true
                var socketThread = SocketThread()
                socketThread.start()
            }
        }


    }

    inner class SocketThread : Thread(){

        override fun run() {
            socket = Socket(ip, port)
            outStream = socket.outputStream
            inStream = socket.inputStream
            while (isRuning){
                val available = inStream.available() // 데이터가 있으면 데이터의 사이즈 없다면 -1을 반환합니다.
                if (available > 0){
                    val dataArr = ByteArray(available) // 사이즈에 맞게 byte array를 만듭니다.
                    outStream.write(dataArr) // byte array에 데이터를 씁니다.
                    val data = String(dataArr) // byte array의 데이터를 통해 String을 만듭니다.
                    //println("data : ${data}")
                    textView.text = data
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRuning = false
    }
}
