package com.example.trialapp

import com.google.gson.annotations.SerializedName

//@SerializedName "source") var source:String,

    data class Article( @SerializedName("author") var author:String, @SerializedName("title") var title:String,
                       @SerializedName("description") var description:String, @SerializedName("url") var url:String  ,@SerializedName("urlToImage") var urlToImage:String  ,
                       @SerializedName("publishedAt") var publishedAt:String ,@SerializedName("content") var content:String  ){
        }

/*data class ArticleList*/

