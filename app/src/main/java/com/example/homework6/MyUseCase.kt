package com.example.homework6

class MyUseCase(private val repository: MyRepository) {
    suspend operator fun invoke(city: String): WeatherResponse {
        return repository.getWeather(city)
    }
}