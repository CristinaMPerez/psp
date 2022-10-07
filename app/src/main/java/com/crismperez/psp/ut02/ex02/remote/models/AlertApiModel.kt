package com.crismperez.psp.ut02.ex02.remote.models


data class AlertResponse( val statusCode: String,val data: List<Alert>)

data class Alert (val id: String, val title: String)

