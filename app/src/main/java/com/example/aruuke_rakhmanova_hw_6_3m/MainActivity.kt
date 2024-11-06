package com.example.aruuke_rakhmanova_hw_6_3m

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aruuke_rakhmanova_hw_6_3m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val adapter = AdapterAnimal()
    lateinit var binding: ActivityMainBinding
    private val imageIdList = listOf(
        R.drawable.cat,
        R.drawable.dog,
        R.drawable.panda,
        R.drawable.tiger,
        R.drawable.bunny
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rvAnimal.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rvAnimal.adapter = adapter
            btnAdd.setOnClickListener {
                if (index > 4 ) index = 0
                val animal = Animal(imageIdList[index], "Animal $index")
                adapter.addAnimal(animal)
                index++
            }
        }
    }
}