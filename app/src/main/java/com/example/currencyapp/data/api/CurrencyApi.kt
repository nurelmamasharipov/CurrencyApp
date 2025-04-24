package com.example.currencyapp.data.api

import com.example.currencyapp.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {
    @GET("v6/8d415032f5623bf092bbbc18/latest/USD")
    suspend fun getRates(): Response<CurrencyResponse>
}