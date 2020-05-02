package com.example.trialapp

import com.google.gson.annotations.SerializedName

   // data class Article(var source:String, var author:String, var title:String, var description:String, var url:String, var urlImage:String, var publishedAt:String, var content:String){

data class ListOfArticles(@SerializedName("status") var status :String, @SerializedName("totalResults") var totalResult :Int, val articles:List<Article>){

}

