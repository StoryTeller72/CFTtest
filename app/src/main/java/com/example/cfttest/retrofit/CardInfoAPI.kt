package com.example.cfttest.retrofit

import retrofit2.http.GET

interface CardInfoAPI {
    @GET("/45717360")
    suspend fun getCardByBIN(): CardInfo
}