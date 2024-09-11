package com.example.blog.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class JoinResponse(
    val email: String,
    val password: String,
    val nickname: String,
    val name: String
)
