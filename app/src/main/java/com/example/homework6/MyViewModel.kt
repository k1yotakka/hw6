package com.example.homework6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val useCase: MyUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Idle)
    val state: StateFlow<UiState> = _state

    fun handleIntent(intent: UiIntent) {
        when (intent) {
            is UiIntent.LoadWeather -> {
                _state.value = UiState.Loading
                viewModelScope.launch {
                    try {
                        val weather = useCase(intent.city)
                        _state.value = UiState.Success(
                            listOf(
                                "Город: ${weather.name}",
                                "Температура: ${weather.main.temp}°C",
                                "Влажность: ${weather.main.humidity}%"
                            )
                        )
                    } catch (e: Exception) {
                        _state.value = UiState.Error(e.message ?: "Ошибка загрузки")
                    }
                }
            }
        }
    }
}
