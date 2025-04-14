package com.example.homework6

sealed class UiIntent {
    data class LoadWeather(val city: String) : UiIntent()
}