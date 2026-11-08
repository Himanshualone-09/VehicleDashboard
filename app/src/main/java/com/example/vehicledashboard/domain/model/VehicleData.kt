package com.example.vehicledashboard.domain.model

data class VehicleData(
    val speed: Int?,
    val motorOn: Boolean?,
    val killSwitchActive: Boolean?,
    val situation: String,
    val timeStamp: Long
)
