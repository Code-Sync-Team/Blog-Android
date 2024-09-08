package com.example.blog.data.repository

import com.example.blog.data.model.JoinResponse
import com.example.blog.data.model.LoginResponse

interface BlogRepository {
    suspend fun login(
        email: String,
        password: String,
    ): Result<LoginResponse>

    suspend fun join(
        email: String,
        password: String,
        nickname: String,
        name: String
    ): Result<JoinResponse>
}
