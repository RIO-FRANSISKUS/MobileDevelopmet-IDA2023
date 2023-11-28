package com.example.pertemuanpertamaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuanpertamaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHero.setHasFixedSize(true)

        list.addAll(getListHero())
        showRecycleList()
    }

    private fun showRecycleList() {

        binding.apply {
            binding.rvHero.layoutManager = LinearLayoutManager(this@MainActivity)
            val listHeroAdapter = ListHeroAdapter(list)
            binding.rvHero.adapter = listHeroAdapter

            listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Hero) {
                    showSelectedHero(data)
                }
            })
        }

    }

    private fun getListHero(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()

        for (i in dataName.indices){
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showSelectedHero(hero: Hero){
        val intentDetailHero = Intent(this@MainActivity, DetailHeroActivity::class.java)
        intentDetailHero.putExtra(DetailHeroActivity.EXTRA_KEY, hero)
        startActivity(intentDetailHero)
    }


}