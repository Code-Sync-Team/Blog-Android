package com.example.blog.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostResponse(
    val status: Int,
    val message: String,
    val data: Data
)

@Serializable
data class Data(
    val author: String,
    val id: Int,
    val title: String,
    val content: String
)
