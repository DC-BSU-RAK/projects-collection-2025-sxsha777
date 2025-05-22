package com.example.nancalc20

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Spinner
import android.widget.TextView
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

        val moodspinner: Spinner = findViewById(R.id.MoodSpinner)
        val timespinner: Spinner = findViewById(R.id.TimeSpinner)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val activityButton: Button = findViewById(R.id.ActivityButton)

        // creating arrays
        val moods = arrayOf("Relaxed", "Happy", "Bored", "Sleepy")
        val time = arrayOf("1-2 hours", "3-4 hours", "5+ hours")

        // assigning the arrays to spinners
        moodspinner.adapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, moods)
        timespinner.adapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_dropdown_item, time)

        // assigning values
        val activities = mapOf(
            "Relaxed" to mapOf(
                "1-2 hours" to "Do your homework!",
                "3-4 hours" to "Try a new recipe!",
                "5+ hours" to "Start a new series"
            ),
            "Happy" to mapOf(
                "1-2 hours" to "Go for a stroll!",
                "3-4 hours" to "Play a game!",
                "5+ hours" to "Go to the mall with friends!"
            ),
            "Bored" to mapOf(
                "1-2 hours" to "Organize your desk!",
                "3-4 hours" to "Clean your room!",
                "5+ hours" to "Build a lego set!"
            ),
            "Sleepy" to mapOf(
                "1-2 hours" to "Read a book!",
                "3-4 hours" to "Watch a movie!",
                "5+ hours" to "Take rest!"
            )
        )
        activityButton.setOnClickListener {
            val selectedMood = moodspinner.selectedItem.toString()
            val selectedTime = timespinner.selectedItem.toString()

            val resultActivity = activities[selectedMood]?.get(selectedTime) ?: "No result.."

            //displaying output
            resultTextView.text = resultActivity
        }
        val helpButton: Button = findViewById(R.id.helpButton)
        helpButton.setOnClickListener {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_popup, null)
            val helpWindow = PopupWindow(popupView, 800, 500, true)
            helpWindow.showAtLocation(popupView, Gravity.BOTTOM, 20, 100)

            val closeButton: Button = popupView.findViewById(R.id.closeButton)
            closeButton.setOnClickListener {
                helpWindow.dismiss()
            }
        }
    }
}