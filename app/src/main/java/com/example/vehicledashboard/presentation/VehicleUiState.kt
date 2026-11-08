package com.example.vehicledashboard.presentation

data class VehicleUiState(
    val speed: Int? = null,
    val motorOn: Boolean? = null,
    val killSwitchActive: Boolean? = null,
    val situation: String? = null,
    val isDataAvailable: Boolean = false,
    val errMessage: String? = null
)