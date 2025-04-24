package com.example.currencyapp.data.model

data class CurrencyResponse(
    val base_code : String,
    val conversion_rates: Map<String, Double>
)
