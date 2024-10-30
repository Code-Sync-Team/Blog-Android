package com.example.blog.data.network

import android.util.Log
import com.example.blog.data.datasource.TokenDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenDataSource: TokenDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (request.url.encodedPath.contains("login") || request.url.encodedPath.contains("join")) {
            Log.d("결과", "intercept: 토큰 사용 X")
            return chain.proceed(request)
        }
        Log.d("결과", "intercept: 토큰 사용 O")
        val token = tokenDataSource.getToken()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(authenticatedRequest)
    }

}
