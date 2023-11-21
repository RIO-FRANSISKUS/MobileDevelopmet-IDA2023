package com.example.pertemuanpertamaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    private lateinit var tvData : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvData = findViewById(R.id.tv_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "nama anda adalah $name dan umur anda adalah $age"

        tvData.text = text

    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }
}