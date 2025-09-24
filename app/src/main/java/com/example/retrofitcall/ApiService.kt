package com.example.retrofitcall

import com.example.retrofitcall.model.PostResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<PostResponseItem>

}