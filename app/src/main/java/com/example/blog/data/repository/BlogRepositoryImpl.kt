package com.example.blog.data.repository

import com.example.blog.data.model.JoinRequest
import com.example.blog.data.model.JoinResponse
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

    override suspend fun join(
        email: String,
        password: String,
        nickname: String,
        name: String
    ): Result<JoinResponse> {
        return try {
            val result = blogService.join(
                joinRequest = JoinRequest(
                    email = email,
                    password = password,
                    nickname = nickname,
                    name = name
                )
            )
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(Exception("회원가입을 실패하였습니다."))
        }
    }
}
