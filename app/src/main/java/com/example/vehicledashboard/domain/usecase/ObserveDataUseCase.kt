package com.example.vehicledashboard.domain.usecase

import com.example.vehicledashboard.domain.repository.VehicleRepository
import javax.inject.Inject

class ObserveDataUseCase @Inject constructor(
    private val repository: VehicleRepository
) {

    operator fun invoke() = repository.observeVehicleData()
}