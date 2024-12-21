package com.example.recyclerviewclicklistener

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityThree : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var displayImage: ImageView
    private lateinit var displayName: TextView
    private lateinit var displayDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        displayImage = findViewById(R.id.displayImageTV)
        displayName = findViewById(R.id.displaynameClotheTV)
        displayDescription = findViewById(R.id.displaydescriptionClotheTV)

        val clothe: Clothes? = intent.getSerializableExtra("clothe") as? Clothes

        clothe?.let {
            displayName.text = it.name
            displayDescription.text = it.discription
            displayImage.setImageResource(it.image)
        }
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