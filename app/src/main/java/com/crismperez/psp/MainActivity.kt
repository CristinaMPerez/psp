package com.crismperez.psp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.crismperez.psp.ut02.ex01.data.remote.RetrofitApiClient
import com.crismperez.psp.ut02.ex02.remote.RetrofitApiAlert

class MainActivity : AppCompatActivity() {

    val apiClient = RetrofitApiClient()
    val apiAlert = RetrofitApiAlert()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread {
                val users = apiClient.getUsers()
                Log.d("@dev", "Usuarios: $users")
        }.start()

        Thread {
            val user = apiClient.getUser(1)
            Log.d("@dev", "Usuarios: $user")
        }.start()

        Thread {
            val alerts = apiAlert.getAlerts()
            Log.d("@dev", "Alerts: $alerts")
        }.start()

        /*Thread {
            val alert = apiAlert.getAlert(3053125)
            Log.d("@dev", "Alert: $alert")
        }.start()*/


    }
}