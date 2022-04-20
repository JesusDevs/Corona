package com.example.corona.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
      const val BASE_URL = "https://covid-19-statistics.p.rapidapi.com/"
        fun retrofitInstance(): ICoronaService {
            val retrofitClient = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitClient.create(ICoronaService::class.java)
        }
    }
}