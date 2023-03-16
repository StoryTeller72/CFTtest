package com.example.cfttest.data.API.cardInfoAPI

import retrofit2.http.GET

interface CardInfoAPI {
    @GET("/45717360")
    suspend fun getCardByBIN(): CardInfo
}