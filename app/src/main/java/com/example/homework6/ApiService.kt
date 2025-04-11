package com.example.homework6

import retrofit2.http.GET

interface ApiService {
    @GET("data")
    suspend fun fetchData(): List<String>
}