package com.example.pertemuanpertamaapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ParcelableDataActivity : AppCompatActivity() {

    private lateinit var tvParcelableData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable_data)

        tvParcelableData = findViewById(R.id.tv_percelable_data)

        val person = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name : ${person.name}, Umur : ${person.age}, email : ${person.email}, Kota: ${person.city}"
            tvParcelableData.text = text

        }
    }

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
}