package com.example.currencyapp.data.repository

import com.example.currencyapp.data.api.RetrofitInstance
import com.example.currencyapp.data.model.CurrencyResponse
import retrofit2.Response

class CurrencyRepository {
    suspend fun getRates(): Response<CurrencyResponse>{
        return RetrofitInstance.api.getRates()
    }
}