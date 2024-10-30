package com.example.blog.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.blog.ui.createblog.CreatePostRoute

const val CREATE_POST_ROUTE = "createPost"

fun NavController.navigateToCreatePost() {
    navigate(CREATE_POST_ROUTE)
}

fun NavGraphBuilder.createPostScreen(
    navController: NavController
) {
    composable(
        route = CREATE_POST_ROUTE
    ) {
        CreatePostRoute(
            navController = navController
        )
    }
}
