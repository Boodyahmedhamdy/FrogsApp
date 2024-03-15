package com.example.frogsapp.data

import com.google.gson.annotations.SerializedName

data class FrogDTO(
    val description: String,
    @SerializedName("img_src")
    val imageSrc: String,
    val name: String,
    val type: String
)