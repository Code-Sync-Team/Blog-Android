package com.example.blog.data.repository

import com.example.blog.data.model.response.CreatePostResponse
import com.example.blog.data.model.response.JoinResponse
import com.example.blog.data.model.response.LoginResponse

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

    suspend fun createPost(
        title: String,
        content: String
    ): Result<CreatePostResponse>
}
