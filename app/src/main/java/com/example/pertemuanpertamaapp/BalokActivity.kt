package com.example.pertemuanpertamaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BalokActivity : AppCompatActivity() {

    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balok)

        tvHasil = findViewById(R.id.hasil_tv)
    }
}