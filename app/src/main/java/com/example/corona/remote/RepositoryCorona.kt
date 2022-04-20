package com.example.corona.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.corona.pojo.DateResponse

class RepositoryCorona {

    private val retrofit = RetrofitClient.retrofitInstance()
    val liveDataDateResponse = MutableLiveData<DateResponse>()

    suspend fun getTotalRepo(date : String  ){
        Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
        try {
            val response = retrofit.getTotal(date, "96afa298cbmsh913f910f914494cp110c39jsn01a32d68445e")

            when(response.isSuccessful) {
                true -> response.body()?.let {
                    liveDataDateResponse.value = it
                    Log.d("repo1", "${it}")

                }
                false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()} ")
            }
        } catch (t: Throwable){
            Log.e("ERROR ", t.message.toString())
        }
    }
}