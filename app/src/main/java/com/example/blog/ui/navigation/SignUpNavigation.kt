package com.example.blog.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.blog.ui.signup.SignUpRoute

const val SIGNUP_ROUTE = "signup"

fun NavGraphBuilder.signUpScreen() {
    composable(
        route = SIGNUP_ROUTE
    ) {
        SignUpRoute()
    }
}
