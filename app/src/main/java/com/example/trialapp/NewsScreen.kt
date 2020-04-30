package com.example.trialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.news_screen.*

class NewsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_screen)
        val FashionBtn = findViewById<Button>(R.id.FashionButton)
        val SportBtn = findViewById<Button>(R.id.SportButton)
        val WellnessBtn = findViewById<Button>(R.id.WellnessButton)
        val TopNews = findViewById<Button>(R.id.TopNewsButton)
        val LifeStyle = findViewById<Button>(R.id.LifeStyleButton)
        val TBDBtn = findViewById<Button>(R.id.TBDButton)

        FashionBtn.setOnClickListener{ReadNews()}
        SportBtn.setOnClickListener{ReadNews()}
        WellnessBtn.setOnClickListener{ReadNews()}
        TopNews.setOnClickListener{ReadNews()}
        LifeStyle.setOnClickListener{ReadNews()}
        TBDBtn.setOnClickListener{ReadNews()}
    }

    private fun ReadNews() {
        val intent = Intent(this, NewsReader::class.java)
        startActivity(intent)
    }


}

