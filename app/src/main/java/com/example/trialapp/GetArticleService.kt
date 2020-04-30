package com.example.trialapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetArticleService {
    @GET("/v2/top-headlines?country=il&apiKey=42f0fcd6f36d462086684082b6449166")
    fun getArticles() : Call<ListOfArticles>
}