package com.example.frogsapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"
    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getFrogsApi(): FrogsApi {
        return getInstance().create(FrogsApi::class.java)
    }
}