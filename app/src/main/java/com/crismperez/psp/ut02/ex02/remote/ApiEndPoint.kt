package com.crismperez.psp.ut02.ex02.remote

import com.crismperez.psp.ut02.ex01.data.remote.models.UserApiModel
import com.crismperez.psp.ut02.ex02.remote.models.AlertResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {

    @GET("alerts")
    fun getAlerts() : Call<List<AlertResponse>>

    @GET("alerts/{alertsId}")
    fun getAlert(@Path("alertsId") userId: Int): Call<UserApiModel>

}