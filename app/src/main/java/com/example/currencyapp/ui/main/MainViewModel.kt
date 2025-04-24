package com.example.currencyapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.data.model.CurrencyResponse
import com.example.currencyapp.data.repository.CurrencyRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val repository = CurrencyRepository()

    private val _rates = MutableLiveData<Response<CurrencyResponse>>()
    val rates: LiveData<Response<CurrencyResponse>> = _rates

    fun fetchRates(){
        viewModelScope.launch {
            val response = repository.getRates()
            _rates.value = response
        }
    }
}