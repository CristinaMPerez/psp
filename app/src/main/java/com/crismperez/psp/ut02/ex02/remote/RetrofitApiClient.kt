package com.crismperez.psp.ut02.ex02.remote

import com.crismperez.psp.ut02.ex01.data.remote.models.UserApiModel
import com.crismperez.psp.ut02.ex02.remote.models.Alert
import com.crismperez.psp.ut02.ex02.remote.models.AlertResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiAlert {

    private val urlEndPoint = "https://plagricola.sitehub.es/"
    private var apiEndPoint : ApiEndPoint

    init {
        apiEndPoint = buildApiEndPoint()
    }

    private fun buildClient () : Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoint(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java)
    }

    fun getAlerts(): List<AlertResponse> {
        val callAlert = apiEndPoint.getAlerts()
        val response = callAlert.execute()

        return if(response.isSuccessful){
            val alerts = response.body()
            alerts ?: emptyList() //devuelve una lista vacia si es nulo
        }else{
            emptyList<AlertResponse>()
        }
    }

    /*fun getAlert(alertId: Int) : AlertResponse? {
        val callAlerts = apiEndPoint.getAlert(alertId)
        val response = callAlerts.execute()
        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }*/
}