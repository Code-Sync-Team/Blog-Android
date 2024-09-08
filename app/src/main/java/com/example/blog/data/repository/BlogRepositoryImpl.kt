package com.example.blog.data.repository

import com.example.blog.data.model.LoginRequest
import com.example.blog.data.model.LoginResponse
import com.example.blog.data.network.BlogService
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    private val blogService: BlogService
) : BlogRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponse> {
        return try {
            val result = blogService.login(LoginRequest(email = email, password = password))
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(Exception("로그인을 실패하였습니다."))
        }
    }
}
