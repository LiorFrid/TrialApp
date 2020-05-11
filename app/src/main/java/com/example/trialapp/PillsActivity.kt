package com.example.trialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import java.util.*

class PillsActivity : AppCompatActivity() {

    private var date: Date? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pills)
        val calender = findViewById<CalendarView>(R.id.calendarView)

        calender.setOnDateChangeListener { _, year, month, dayOfMonth ->
            date= Date(year,month,dayOfMonth)
            println(date)
        }
    }
}
