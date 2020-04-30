
package com.example.trialapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback


class NewsReader : AppCompatActivity() {
    var articleNum=0
    var body:ListOfArticles?=null

    // val newsApiRepository = NewsApiRepository("42f0fcd6f36d462086684082b6449166")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.read_news)
        val NextBtn = findViewById<Button>(R.id.Next)
        val BackBtn = findViewById<Button>(R.id.BackBtn)
        NextBtn.setBackgroundColor(Color.CYAN)
        sendGetRequest()
        NextBtn.setOnClickListener{GetNextArticle()}
        BackBtn.setOnClickListener{GetPrevArticle()}

    }

    private fun GetNextArticle()
    {
        val NewsTextBox = findViewById<TextView>(R.id.theNews)
        articleNum=articleNum+1
        if(articleNum==20)
            articleNum=0
        NewsTextBox.text= body?.articles?.get(articleNum)?.title.toString()
    }

    private fun GetPrevArticle()
    {
        val NewsTextBox = findViewById<TextView>(R.id.theNews)
        articleNum=articleNum-1
        if(articleNum==-1)
            articleNum=19
        NewsTextBox.text= body?.articles?.get(articleNum)?.title.toString()
    }

    private fun  sendGetRequest() {
        val NewsTextBox = findViewById<TextView>(R.id.theNews)
        val service =RetrofitClientInstance.retrofitInstance?.create(GetArticleService::class.java)
        val call=service?.getArticles()
        call?.enqueue(object : Callback<ListOfArticles> {
            override fun onResponse(call: Call<ListOfArticles>, response: retrofit2.Response<ListOfArticles>?) {
                body =response?.body()
                NewsTextBox.text= body?.articles?.get(articleNum)?.title.toString()
            }
            override fun onFailure(call: Call<ListOfArticles>, t: Throwable) {
                Toast.makeText(applicationContext,"Error loading Json",Toast.LENGTH_LONG).show()
            }

        })
    }
}
