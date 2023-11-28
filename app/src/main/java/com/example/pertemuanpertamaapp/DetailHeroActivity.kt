package com.example.pertemuanpertamaapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pertemuanpertamaapp.databinding.ActivityDetailHeroBinding

class DetailHeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_KEY, Hero::class.java)
        } else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("hero")
        }

        if (hero != null){
            Glide.with(this)
                .load(hero.photo) //URL GAMBAR
                .circleCrop()
                .into(binding.ivDetailHero) // imageView mana yang akan diterapkan

            binding.tvDetailName.text = hero.name
            binding.tvDetailDescription.text = hero.description

            binding.btnShare.setOnClickListener {
                val url = hero.photo

                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, url)
                val chooser = Intent.createChooser(shareIntent, "Bagikan dengan: ")
                startActivity(chooser)
            }
        }
    }

    companion object{
        const val EXTRA_KEY = "extra_key"
    }
}