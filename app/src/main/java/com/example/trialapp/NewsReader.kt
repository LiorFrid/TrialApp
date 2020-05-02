
package com.example.trialapp

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Callback
import java.util.*


class NewsReader : AppCompatActivity() , TextToSpeech.OnInitListener{
    var articleNum=0
    var body:ListOfArticles?=null
    var countryCodeForNews:String="IL"
    lateinit var mTTS:TextToSpeech

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.read_news)
        val NextBtn = findViewById<Button>(R.id.Next)
        val BackBtn = findViewById<Button>(R.id.BackBtn)
        var intent=intent
        var newsCat =intent.getStringExtra("category")
        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                //if there is no error then set language
                mTTS.language = Locale.US
            }
        })

        NextBtn.setBackgroundColor(Color.CYAN)
        sendGetRequest(newsCat)
        NextBtn.setOnClickListener{GetNextArticle()}
        BackBtn.setOnClickListener{GetPrevArticle()}


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun GetNextArticle()
    {
        val NewsTextBox = findViewById<TextView>(R.id.theNews)
        articleNum=articleNum+1
        if(articleNum==20)
            articleNum=0
        NewsTextBox.text= body?.articles?.get(articleNum)?.title.toString()
        mTTS!!.speak(NewsTextBox.text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun GetPrevArticle()
    {
        val NewsTextBox = findViewById<TextView>(R.id.theNews)
        articleNum=articleNum-1
        if(articleNum==-1)
            articleNum=19
        NewsTextBox.text= body?.articles?.get(articleNum)?.title.toString()
        mTTS!!.speak(NewsTextBox.text, TextToSpeech.QUEUE_FLUSH, null,"")
    }

    private fun  sendGetRequest(catagory:String) {
        val NewsTextBox = findViewById<TextView>(R.id.theNews)
        val service =RetrofitClientInstance.retrofitInstance?.create(GetArticleService::class.java)
        val call=service?.getArticles("us",catagory,"42f0fcd6f36d462086684082b6449166")
        call?.enqueue(object : Callback<ListOfArticles> {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onResponse(call: Call<ListOfArticles>, response: retrofit2.Response<ListOfArticles>?) {
                body =response?.body()
                NewsTextBox.text= body?.articles?.get(articleNum)?.title.toString()
                mTTS!!.speak(NewsTextBox.text, TextToSpeech.QUEUE_FLUSH, null,"")
            }
            override fun onFailure(call: Call<ListOfArticles>, t: Throwable) {
                Toast.makeText(applicationContext,"Error loading Json",Toast.LENGTH_LONG).show()
            }

        })
    }
    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = mTTS!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                //Log.e("TTS","The Language specified is not supported!")
            } else {
                //buttonSpeak!!.isEnabled = true
            }

        } else {
            //Log.e("TTS", "Initilization Failed!")
        }

    }

    override fun onBackPressed() {
        if (mTTS != null) {
            mTTS!!.stop()
            mTTS!!.shutdown()
        }
        startActivity(Intent(this, NewsScreen::class.java))
        finish()
    }
}
