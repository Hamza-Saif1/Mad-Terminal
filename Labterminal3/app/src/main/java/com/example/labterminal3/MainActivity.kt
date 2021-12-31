package com.example.labterminal3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var reciver : BroadcastReceiver
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        reciver=object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context,intent?.action,Toast.LENGTH_LONG).show()
            }

        }
        registerReceiver(reciver,filter)
        btn.setOnClickListener{
            sendBroadcast(Intent(context,MyReceiver::class.java))
        }
    }

    override fun onDestroy() {
        unregisterReceiver(reciver)
        super.onDestroy()
    }
}