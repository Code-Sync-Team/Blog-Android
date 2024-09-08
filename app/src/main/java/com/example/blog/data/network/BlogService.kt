package com.example.blog.data.network

import com.example.blog.data.model.JoinRequest
import com.example.blog.data.model.JoinResponse
import com.example.blog.data.model.LoginRequest
import com.example.blog.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface BlogService {
    @POST("api/v1/user/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : LoginResponse

    @POST("api/v1/user/join")
    suspend fun join(
        @Body joinRequest: JoinRequest
    ) : JoinResponse
}
