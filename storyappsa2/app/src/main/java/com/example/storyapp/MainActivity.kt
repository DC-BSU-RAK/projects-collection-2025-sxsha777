package com.example.storyapp

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.PopupWindow
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonStory1: Button = findViewById(R.id.buttonStory1)
        val buttonStory2: Button = findViewById(R.id.buttonStory2)
        val buttonStory3: Button = findViewById(R.id.buttonStory3)
        val buttonStory4: Button = findViewById(R.id.buttonStory4)
        val buttonStory5: Button = findViewById(R.id.buttonStory5)
        buttonStory1.setOnClickListener {
            startActivity(Intent(this, Story1::class.java))
        }
        buttonStory2.setOnClickListener {
            startActivity(Intent(this, Story2::class.java))
        }
        buttonStory3.setOnClickListener {
            startActivity(Intent(this, Story3::class.java))
        }
        buttonStory4.setOnClickListener {
            startActivity(Intent(this, Story4::class.java))
        }
        buttonStory5.setOnClickListener {
            startActivity(Intent(this, Story5::class.java))
    }
        val helpButton : Button = findViewById(R.id.helpButton)
        helpButton.setOnClickListener{
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_popup,null)
            val helpWindow = PopupWindow(popupView, 800,500,true)
            helpWindow.showAtLocation(popupView, Gravity.BOTTOM,20,100)

            val closeButton : Button = popupView.findViewById(R.id.closeButton)
            closeButton.setOnClickListener{
                helpWindow.dismiss()
            }
        }
        val prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val lastStory = prefs.getInt("lastStory", 0)

        if (lastStory != 0) {
            val continueButton = findViewById<Button>(R.id.continueButton) // add this button in your XML
            continueButton.visibility = View.VISIBLE
            continueButton.setOnClickListener {
                val intent = when (lastStory) {
                    1 -> Intent(this, Story1::class.java)
                    2 -> Intent(this, Story2::class.java)
                    3 -> Intent(this, Story3::class.java)
                    4 -> Intent(this, Story4::class.java)
                    5 -> Intent(this, Story5::class.java)
                    else -> null
                }
                intent?.let { startActivity(it) }
            }
    }
}
}