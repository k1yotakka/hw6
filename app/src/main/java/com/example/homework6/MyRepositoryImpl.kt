package com.example.homework6

import com.example.homework6.ApiService

class MyRepositoryImpl(
    private val apiService: ApiService
) : MyRepository {
    override suspend fun getWeather(city: String): WeatherResponse {
        val apiKey = "a3f3bf452f87b28139ce4c13655d59b6"
        return apiService.getWeatherByCity(city, apiKey)
    }
}