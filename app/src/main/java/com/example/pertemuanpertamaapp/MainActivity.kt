package com.example.pertemuanpertamaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)

        btnStart.setOnClickListener{

            val moveIntent = Intent(this@MainActivity, BalokActivity::class.java)
            startActivity(moveIntent)

        }

    }
}