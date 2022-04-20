package com.example.corona.remote

import com.example.corona.pojo.DateResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ICoronaService {
    @GET("reports/total")
    suspend fun getTotal(@Query("date") date: String  ,@Header("X-RapidAPI-Key") apiKey: String ):
            Response<DateResponse>

}