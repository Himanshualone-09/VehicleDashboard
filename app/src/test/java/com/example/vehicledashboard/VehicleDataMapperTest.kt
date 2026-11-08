package com.example.vehicledashboard

import com.example.vehicledashboard.data.mapper.VehicleDataMapper
import com.example.vehicledashboard.domain.model.VehicleData
import junit.framework.TestCase.assertEquals
import org.junit.Test

class VehicleDataMapperTest {

    @Test
    fun `valid vehicle data is mapped correctly` () {
        val vehicleData = VehicleData(
            speed = 25,
            motorOn = true,
            killSwitchActive = false,
            situation = "Riding",
            timeStamp = 1000L
        )

        val currentTime = 1500L

        val result = VehicleDataMapper.toUiState(
            vehicleData, currentTime
        )

        assertEquals(25, result.speed)
        assertEquals(true, result.motorOn)
        assertEquals(false, result.killSwitchActive)
        assertEquals("Riding", result.situation)
        assertEquals(true, result.isDataAvailable)

    }

    @Test
    fun `negative speed is invalid data` () {

        val vehicleData = VehicleData(
            speed = -10,
            motorOn = true,
            killSwitchActive = false,
            situation = "Riding",
            timeStamp = 1000L
        )

        val currentTime = 1500L

        val result = VehicleDataMapper.toUiState(
            vehicleData, currentTime
        )

        assertEquals(null, result.speed)
        assertEquals(false, result.isDataAvailable)
    }

    @Test
    fun `stale vehicle data is marked unavailable`() {
        val vehicleData = VehicleData(
            speed = 25,
            motorOn = true,
            killSwitchActive = false,
            situation = "Riding",
            timeStamp = 1000L
        )

        val result = VehicleDataMapper.toUiState(
            vehicleData, 5000L
        )

        assertEquals(null, result.speed)
        assertEquals(false, result.isDataAvailable)
        assertEquals("Data Stale", result.situation)
    }

    @Test
    fun `data at stale timeout boundary is still valid`() {
        val vehicleData = VehicleData(
            speed = 25,
            motorOn = true,
            killSwitchActive = false,
            situation = "Riding",
            timeStamp = 1000L
        )

        val result = VehicleDataMapper.toUiState(
            vehicleData, 4000L
        )

        assertEquals(25, result.speed)
        assertEquals(true, result.isDataAvailable)
    }


}