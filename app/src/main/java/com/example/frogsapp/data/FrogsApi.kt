package com.example.frogsapp.data

import retrofit2.Call
import retrofit2.http.GET

interface FrogsApi {

    @GET("amphibians/")
    fun getAllFrogs(): Call<List<FrogDTO>>

}