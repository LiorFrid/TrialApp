package com.example.trialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_landing)
        val NewsBtn = findViewById<Button>(R.id.newsBtn)
        val pillsBtn = findViewById<Button>(R.id.pillsBtn)

        NewsBtn.setOnClickListener { GoToNewsScreen() }
        pillsBtn.setOnClickListener { GoToPillsScreen() }

    }

    private fun GoToPillsScreen() {
        val intent = Intent(this, PillsActivity::class.java)
        startActivity(intent)
    }

    private fun GoToNewsScreen() {
        val intent = Intent(this, NewsScreen::class.java)
        startActivity(intent)

    }

}



