package com.example.trialapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GetArticleService {
    @GET("/v2/top-headlines/")
    fun getArticles(@Query("country") country:String, @Query("category") category: String, @Query("apiKey") apiKey:String ) : Call<ListOfArticles>
}//@Path("Country") country:String,