package com.example.blog.data.datasource

interface TokenDataSource {
    fun getToken(): String?
    suspend fun saveToken(token: String)
}
