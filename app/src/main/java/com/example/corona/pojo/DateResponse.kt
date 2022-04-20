package com.example.corona.pojo


import com.google.gson.annotations.SerializedName

data class DateResponse(
    @SerializedName("data")
    val `data`: Data
)