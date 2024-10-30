package com.example.blog.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostRequest(
    val title: String,
    val content: String,
    val category: String = "FIRST"
)
