package com.example.homework6


interface MyRepository {
    suspend fun getWeather(city: String): WeatherResponse
}