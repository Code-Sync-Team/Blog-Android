package com.example.blog.data.repository

import com.example.blog.data.model.request.JoinRequest
import com.example.blog.data.model.request.LoginRequest
import com.example.blog.data.model.response.JoinResponse
import com.example.blog.data.model.response.LoginResponse
import com.example.blog.data.network.BlogService
import kotlinx.serialization.Serializable
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

@Serializable
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
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = JSONObject(errorBody ?: "").getString("message")
            Result.failure(Exception(errorResponse))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
