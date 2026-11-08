package com.example.vehicledashboard.data.mapper

import com.example.vehicledashboard.domain.model.VehicleData
import com.example.vehicledashboard.presentation.VehicleUiState

object VehicleDataMapper {

    private const val STALE_TIMEOUT = 3000L

    fun toUiState(
        data: VehicleData,
        currentTime: Long
    ): VehicleUiState {

        val speed = data.speed

        val isValid = speed != null && speed >= 0 && data.motorOn != null
                && data.killSwitchActive != null && data.situation.isNotBlank()

        if(!isValid) {
            return VehicleUiState(
                situation = "Invalid Data",
                errMessage = "One or more signals are invalid"
            )
        }

        val diff = currentTime - data.timeStamp

        if(diff > STALE_TIMEOUT) {
            return VehicleUiState(
                situation = "Data Stale",
                errMessage = "Vehicle data is stale"
            )
        }

        return VehicleUiState(
            speed = speed,
            motorOn = data.motorOn,
            killSwitchActive = data.killSwitchActive,
            situation = data.situation,
            isDataAvailable = true
        )
    }
}