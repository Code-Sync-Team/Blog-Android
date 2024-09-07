package com.example.blog.ui.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SignUpRoute(
    modifier: Modifier = Modifier
) {
    SignUpScreen()
}

@Composable
private fun SignUpScreen(modifier: Modifier = Modifier) {
    Text(text = "Hello, World")
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}
