package com.example.blog.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.blog.ui.signup.SignUpRoute

const val BLOG_ROUTE = "blog"

fun NavGraphBuilder.blogScreen() {
    composable(
        route = BLOG_ROUTE
    ) {
        SignUpRoute()
    }
}
