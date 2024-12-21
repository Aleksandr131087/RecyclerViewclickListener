package com.example.recyclerviewclicklistener

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var TextViewTV: TextView
    private lateinit var ButtonStartBTN: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextViewTV = findViewById(R.id.TextViewTV)
        ButtonStartBTN = findViewById(R.id.ButtonStartBTN)
        ButtonStartBTN.setOnClickListener {
            val intent = Intent(this, ActivityTwo::class.java)
            startActivity(intent)
        }
    }
}