package com.example.storyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Story1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonNext: Button = findViewById(R.id.nextbutton)
        val buttonPrevious: Button = findViewById(R.id.prvbutton)
        buttonNext.setOnClickListener {
            startActivity(Intent(this, Story2::class.java))
        }
        buttonPrevious.setOnClickListener {
            finish() // Go back to Menu
        }
        val prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        prefs.edit().putInt("lastStory", 1).apply()
    }
}