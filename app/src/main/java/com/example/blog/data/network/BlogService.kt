package com.example.blog.data.network

import com.example.blog.data.model.request.JoinRequest
import com.example.blog.data.model.response.JoinResponse
import com.example.blog.data.model.request.LoginRequest
import com.example.blog.data.model.response.LoginResponse
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
