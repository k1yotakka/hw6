package com.example.homework6

class MyUseCase(private val repository: MyRepository) {
    suspend operator fun invoke(): List<String> {
        return repository.getData()
    }
}