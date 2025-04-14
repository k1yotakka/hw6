package com.example.homework6

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    data class Success(val data: List<String>) : UiState()
    data class Error(val message: String) : UiState()
}