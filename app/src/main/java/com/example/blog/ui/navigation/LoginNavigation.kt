package com.example.blog.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.blog.ui.login.LoginRoute

const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginScreen(
    onNavigateToSignUp: () -> Unit,
    onNavigateToMain: () -> Unit
) {
    composable(
        route = LOGIN_ROUTE
    ) {
        LoginRoute(
            onNavigateToSignUp = onNavigateToSignUp,
            onNavigateToMain = onNavigateToMain
        )
    }
}
