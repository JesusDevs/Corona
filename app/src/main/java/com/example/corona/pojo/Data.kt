package com.example.corona.pojo


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("active")
    val active: Int,
    @SerializedName("active_diff")
    val activeDiff: Int,
    @SerializedName("confirmed")
    val confirmed: Int,
    @SerializedName("confirmed_diff")
    val confirmedDiff: Int,
    @SerializedName("date")
    val date: String,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("deaths_diff")
    val deathsDiff: Int,
    @SerializedName("fatality_rate")
    val fatalityRate: Double,
    @SerializedName("last_update")
    val lastUpdate: String,
    @SerializedName("recovered")
    val recovered: Int,
    @SerializedName("recovered_diff")
    val recoveredDiff: Int
)