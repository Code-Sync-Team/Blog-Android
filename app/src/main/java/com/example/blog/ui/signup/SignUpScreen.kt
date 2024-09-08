package com.example.blog.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.blog.ui.theme.BlogTheme

@Composable
fun SignUpRoute(
    modifier: Modifier = Modifier
) {
    SignUpScreen()
}

@Composable
private fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val signUpUiState by viewModel.uiState.collectAsState()
    val inputModifier = Modifier.padding(top = 20.dp)

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NickNameInput(
                value = signUpUiState.nickname,
                onValueChange = viewModel::updateNickname,
                modifier = inputModifier
            )

            EmailInput(
                value = signUpUiState.email,
                onValueChange = viewModel::updateEmail,
                modifier = inputModifier
            )

            PasswordInput(
                value = signUpUiState.password,
                onValueChange = viewModel::updatePassword,
                modifier = inputModifier
            )

            NameInput(
                value = signUpUiState.name,
                onValueChange = viewModel::updateName,
                modifier = inputModifier
            )
            SignUpButton(
                onClick = {
                    viewModel.join(
                        email = signUpUiState.email,
                        password = signUpUiState.password,
                        nickname = signUpUiState.nickname,
                        name = signUpUiState.name
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.Gray
                ),
                enabled = signUpUiState.isSignUpButtonEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    BlogTheme {
        SignUpScreen(
            modifier = Modifier
        )
    }
}
