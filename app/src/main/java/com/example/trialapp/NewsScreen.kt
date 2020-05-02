package com.example.trialapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class NewsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.news_screen)
        val FashionBtn = findViewById<Button>(R.id.FashionButton)
        val SportBtn = findViewById<Button>(R.id.SportButton)
        val WellnessBtn = findViewById<Button>(R.id.WellnessButton)
        val Entertainment = findViewById<Button>(R.id.EntertainmentBtn)
        val LifeStyle = findViewById<Button>(R.id.LifeStyleButton)
        val Politics = findViewById<Button>(R.id.PoliticsBtn)

        FashionBtn.setOnClickListener{ReadNews("fashion")}
        SportBtn.setOnClickListener{ReadNews("sport")}
        WellnessBtn.setOnClickListener{ReadNews("wellness")}
        Entertainment.setOnClickListener{ReadNews("entertainment")}
        LifeStyle.setOnClickListener{ReadNews("lifestyle")}
        Politics.setOnClickListener{ReadNews("politics")}
    }

    private fun ReadNews(catagoryForNews:String) {
        val intent = Intent(this, NewsReader::class.java)
        intent.putExtra("category", catagoryForNews)
        startActivity(intent)
    }




}

