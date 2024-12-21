package com.example.recyclerviewclicklistener

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityTwo : AppCompatActivity() {

    private val clothes= mutableListOf(
        Clothes("Куртка", "зимняя куртка", R.drawable.kurtka),
        Clothes("Куртка2", "осенняя куртка", R.drawable.kurtka2),
        Clothes("Пиджак", "пиджак голубой", R.drawable.pidzak_blue),
        Clothes("Пиджак", "пиджак черный", R.drawable.pidzak),
        Clothes("Куртка", "зимняя куртка", R.drawable.kurtka),
        Clothes("джемпер", "джемпер желтый", R.drawable.gemper),
        Clothes("джемпер2", "джемпер голубой", R.drawable.gemper2),
        Clothes("джемпер3", "джемпер вязаный", R.drawable.gemper3),
        Clothes("Худи", "худи желтый", R.drawable.hudy),
        Clothes("Шорты", "шорты мужские", R.drawable.shorty),
        Clothes("Джинсы", "джинсы синие", R.drawable.jeans2),
        Clothes("Джинсы2", "джинсы рваные", R.drawable.jeans2),
        Clothes("Брюки", "брюки серые", R.drawable.bryki_grey),
        Clothes("Брюки2", "брюки черные", R.drawable.bryky_black),
        Clothes("Футболка", "футболка голубая", R.drawable.futbalka),
        Clothes("Футболка2", "футболка черная", R.drawable.futbalka2),
        Clothes("Футболка3", "футболка черно-белая", R.drawable.futbalka3),
        Clothes("Футболка4", "футболка с принтом", R.drawable.futbalka4),
        Clothes("Рубашка", "рубашка красная", R.drawable.rubashka_red),
        Clothes("Рубашка2", "рубашка голубая", R.drawable.rubashka_blue),
        Clothes("Рубашка3", "рубашка белая", R.drawable.rubashka),

        )
    private lateinit var toolbar: Toolbar
    private lateinit var RecyclerViewRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        RecyclerViewRV = findViewById(R.id.RecyclerViewRV)
        RecyclerViewRV.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(clothes)
        RecyclerViewRV.adapter = adapter
        RecyclerViewRV.setHasFixedSize(true)
        adapter.setOnClothesClickListener(object : CustomAdapter.OnClothesClickListener {
            override fun onClothesClick(clothe: Clothes, position: Int) {
                val intent = Intent(this@ActivityTwo, ActivityThree::class.java)
                intent.putExtra("clothe", clothe)
                startActivity(intent)
            }
        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}