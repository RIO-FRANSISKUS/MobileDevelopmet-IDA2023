package com.example.pertemuanpertamaapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailHeroActivity : AppCompatActivity() {

    private lateinit var ivDetailHero : ImageView
    private lateinit var tvDetailName : TextView
    private lateinit var tvDetailDescription : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero)

        ivDetailHero = findViewById(R.id.iv_detail_hero)
        tvDetailName = findViewById(R.id.tv_detail_name)
        tvDetailDescription = findViewById(R.id.tv_detail_description)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_KEY, Hero::class.java)
        } else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("hero")
        }

        if (hero != null){
            ivDetailHero.setImageResource(hero.photo)
            tvDetailName.text = hero.name
            tvDetailDescription.text = hero.description
        }
    }

    companion object{
        const val EXTRA_KEY = "extra_key"
    }
}