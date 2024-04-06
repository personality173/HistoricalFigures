package com.example.historicalfigures

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("born") val born: String?,
    @SerializedName("died") val died: String?,
    @SerializedName("cause_of_death") val cause_of_death: String?,
)
