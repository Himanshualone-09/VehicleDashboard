# Vehicle DashBoard

An Android vehicle dashboard application. It displays simulated vehicle information and 
updates the dashboard ui reactively using kotlin flow.

## Features

- Displays vehicle speed in km/h
- Shows motor status (ON/OFF)
- Shows kill-switch status (Active/Inactive)
- Updates vehicle information every second
- Displays different vehicle states:
    - Parked
    - Ready
    - Riding
    - Accelerating
    - Motor Disabled
- Handles invalid and stale vehicle data


## Tech Stack

- Kotlin
- Jetpack Compose
- Coroutines and Flow
- StateFlow
- Clean Architecture
- Hilt
- JUnit

## Architecture

The project follows below mentioned architecture:

- Data: Provides simulated vehicle data, handles data mapping and repository implementation.
- Domain: Contains the model, repository and use case.
- Presentation: Contains the Viewmodel and Compose UI.

The Viewmodel observes simulated vehicle data and exposes the UI state through StateFlow. The UI collects this state and updates whenever new data is received. Hilt for Dependency Injection

## Error Handling

- Negative or missing speed values are considered as invalid data.
- Missing vehicle signals are handles.
- Data older than 3 seconds is treated as stale.

## Unit Testing

Unit tests are included for:

- Valid vehicle data mapping.
- Invalid vehicle data

## How to Run

1. Clone this repository
2. Open the project in Android Studio
3. Allow Gradle sync to complete.
4. Run the app on an Android emulator or device

The dashboard is designed for landscape orientation





