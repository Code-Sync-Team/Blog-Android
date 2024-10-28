package com.example.blog.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.blog.ui.main.BookListRoute

const val MAIN_ROUTE = "main"

fun NavController.navigateToMain() {
    navigate(MAIN_ROUTE)
}

fun NavGraphBuilder.mainScreen(
    navController: NavController
) {
    composable(
        route = MAIN_ROUTE
    ) {
        BookListRoute(
            onNavigateToBlogWrite = { }
        )
    }
}
