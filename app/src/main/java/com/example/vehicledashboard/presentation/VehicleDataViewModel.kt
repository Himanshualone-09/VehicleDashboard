package com.example.vehicledashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vehicledashboard.data.mapper.VehicleDataMapper
import com.example.vehicledashboard.domain.usecase.ObserveDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class VehicleDataViewModel @Inject constructor(
    private val observeDataUseCase: ObserveDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(VehicleUiState())
    val uiState = _uiState.asStateFlow()

    init {
        observeVehicleData()
    }

    fun observeVehicleData() {
        viewModelScope.launch {

            val clockFlow = flow {
                while (true) {
                    emit(System.currentTimeMillis())
                    delay(1.seconds)
                }
            }

            combine(
                observeDataUseCase(),
                clockFlow
            ) { data, currentTime ->

                VehicleDataMapper.toUiState(data, currentTime)

            }.catch { exception ->

                _uiState.value = VehicleUiState(
                    situation = "Data unavailable",
                    errMessage = exception.message ?: "Unable to receive data"
                )

            }.collect { state ->
                _uiState.value = state
            }
        }
    }


}