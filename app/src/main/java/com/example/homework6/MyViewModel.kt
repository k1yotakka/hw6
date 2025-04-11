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

    private val _data = MutableStateFlow<List<String>>(emptyList())
    val data: StateFlow<List<String>> = _data

    init {
        viewModelScope.launch {
            _data.value = useCase()
        }
    }
}