package com.example.blog.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.blog.ui.signup.SignUpRoute

const val SIGNUP_ROUTE = "signup"

fun NavController.navigateToSignUp() {
    navigate(SIGNUP_ROUTE)
}

fun NavGraphBuilder.signUpScreen(
    navController: NavController
) {
    composable(
        route = SIGNUP_ROUTE
    ) {
        SignUpRoute(
            navController = navController
        )
    }
}
