package com.example.blog.data.repository

import android.util.Log
import com.example.blog.data.datasource.TokenDataSource
import com.example.blog.data.model.request.CreatePostRequest
import com.example.blog.data.model.request.JoinRequest
import com.example.blog.data.model.request.LoginRequest
import com.example.blog.data.model.response.CreatePostResponse
import com.example.blog.data.model.response.JoinResponse
import com.example.blog.data.model.response.LoginResponse
import com.example.blog.data.network.BlogService
import kotlinx.serialization.Serializable
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

@Serializable
class BlogRepositoryImpl @Inject constructor(
    private val blogService: BlogService,
    private val tokenDataSource: TokenDataSource
) : BlogRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponse> {
        return try {
            val result = blogService.login(LoginRequest(email = email, password = password))
            tokenDataSource.saveToken(result.token.accessToken)
            Result.success(result)
        } catch (e: Exception) {
            Log.d("결과", "login-error: $e")
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

    override suspend fun createPost(
        title: String,
        content: String,
    ): Result<CreatePostResponse> {
        return try {
            val result = blogService.createPost(
                createPostRequest = CreatePostRequest(
                    title = title,
                    content = content
                )
            )
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
