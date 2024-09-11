package com.example.blog.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class JoinRequest(
    val email: String,
    val password: String,
    val nickname: String,
    val name: String
)
