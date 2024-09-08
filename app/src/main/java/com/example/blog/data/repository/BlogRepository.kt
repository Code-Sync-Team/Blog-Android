package com.example.blog.data.repository

import com.example.blog.data.model.LoginResponse

interface BlogRepository {
    suspend fun login(
        email: String,
        password: String,
    ): Result<LoginResponse>
}
