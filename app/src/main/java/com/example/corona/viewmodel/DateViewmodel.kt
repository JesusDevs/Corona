package com.example.corona.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corona.pojo.DateResponse
import com.example.corona.remote.RepositoryCorona
import kotlinx.coroutines.launch

class DateViewmodel : ViewModel() {

    private val repository : RepositoryCorona
    val getTotalDate : LiveData<DateResponse>

    init {
        repository = RepositoryCorona()
        getTotalDate = repository.liveDataDateResponse
    }

    fun getTotalDate(date :String) = viewModelScope.launch {
        repository.getTotalRepo(date)
    }
}