package com.crismperez.psp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crismperez.psp.ut02.data.remote.RetrofitApiClient

class MainActivity : AppCompatActivity() {

    val apiClient = RetrofitApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient.getUsers()
    }
}