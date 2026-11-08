package com.example.vehicledashboard

import androidx.lifecycle.viewModelScope
import com.example.vehicledashboard.domain.model.VehicleData
import com.example.vehicledashboard.domain.usecase.ObserveDataUseCase
import com.example.vehicledashboard.presentation.VehicleDataViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VehicleDataViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `repo emits data and viewmodel updates uiState`() = runTest {

        val vehicleData = VehicleData(
            speed = 25,
            motorOn = true,
            killSwitchActive = false,
            situation = "Riding",
            timeStamp = System.currentTimeMillis()
        )

        val fakeVehicleRepository = FakeVehicleRepository(vehicleData)

        val useCase = ObserveDataUseCase(fakeVehicleRepository)

        val viewModel = VehicleDataViewModel(useCase)

        runCurrent()

        val result = viewModel.uiState.value

        assertEquals(25, result.speed)
        assertEquals(true, result.motorOn)
        assertEquals(false, result.killSwitchActive)
        assertEquals("Riding", result.situation)
        assertEquals(true, result.isDataAvailable)

        viewModel.viewModelScope.cancel()
    }

    @Test
    fun `repo failure produces error state`() = runTest {
        val fakeVehicleRepository = FakeVehicleRepository(shouldThrowError = true)

        val useCase = ObserveDataUseCase(fakeVehicleRepository)

        val viewModel = VehicleDataViewModel(useCase)

        runCurrent()

        val result = viewModel.uiState.value

        assertEquals("Data unavailable", result.situation)
        assertEquals(false, result.isDataAvailable)

        viewModel.viewModelScope.cancel()
    }
}