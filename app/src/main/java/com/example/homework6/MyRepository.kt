package com.example.homework6


interface MyRepository {
    suspend fun getData(): List<String>
}