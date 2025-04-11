package com.example.homework6

import com.example.homework6.ApiService

class MyRepositoryImpl(
    private val apiService: ApiService
) : MyRepository {
    override suspend fun getData(): List<String> {
        return listOf("Apple", "Banana", "Cherry", "Grape")
    }
}