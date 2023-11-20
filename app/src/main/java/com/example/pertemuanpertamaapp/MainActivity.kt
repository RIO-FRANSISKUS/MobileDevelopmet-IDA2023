package com.example.pertemuanpertamaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnExplicitIntent : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExplicitIntent = findViewById(R.id.btn_explicit_intent)

        btnExplicitIntent.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_explicit_intent -> {
                val moveActivity = Intent(this@MainActivity, ExplicitIntentActivity::class.java)
                startActivity(moveActivity)
            }


        }
    }
}