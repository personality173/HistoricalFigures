package com.example.historicalfigures

import com.google.gson.annotations.SerializedName

data class Figure(
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("info") val info: Info,
)
