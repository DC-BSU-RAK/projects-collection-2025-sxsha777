package com.example.storyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Story4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_story4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonNext: Button = findViewById(R.id.nextbutton3)
        val buttonPrevious: Button = findViewById(R.id.prvbutton3)
        buttonNext.setOnClickListener {
            startActivity(Intent(this, Story5::class.java))
        }
        buttonPrevious.setOnClickListener {
            finish() // Go back to Story3
        }
        val prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        prefs.edit().putInt("lastStory", 4).apply()
    }
}