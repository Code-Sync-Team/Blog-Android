package com.example.blog.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun BlogNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LOGIN_ROUTE,
        modifier = modifier
    ) {
        loginScreen(
            onNavigateToSignUp = { navController.navigateToSignUp() },
            onNavigateToMain = { navController.navigateToMain() }
        )
        signUpScreen(
            navController = navController
        )
        mainScreen(
            onNavigateToCreatePost = { navController.navigateToCreatePost() }
        )
        createPostScreen(
            navController = navController
        )
    }

}
