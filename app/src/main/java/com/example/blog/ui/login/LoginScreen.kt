package com.example.blog.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.blog.R
import com.example.blog.ui.components.BasicButton
import com.example.blog.ui.components.BasicTextField
import com.example.blog.ui.components.PasswordTextField

@Composable
fun LoginRoute(
    onNavigateToSignUp: () -> Unit,
    onNavigateToMain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: LoginViewModel = hiltViewModel()
    LoginScreen(
        viewModel = viewModel,
        onNavigateToSignUp = onNavigateToSignUp,
        onNavigateToMain = onNavigateToMain,
        modifier = modifier
    )
}

@Composable
private fun LoginScreen(
    viewModel: LoginViewModel,
    onNavigateToSignUp: () -> Unit,
    onNavigateToMain: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val loginUiState by viewModel.loginUiState.collectAsState()

    if (loginUiState.isLoginSuccessful) {
        onNavigateToMain()
    }

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        LoginContent(
            loginUiState = loginUiState,
            onEmailChange = viewModel::updateEmail,
            onPasswordChange = viewModel::updatePassword,
            onLogin = { viewModel.login(loginUiState.email, loginUiState.password) },
            onNavigateToSignUp = onNavigateToSignUp,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun LoginContent(
    loginUiState: LoginUiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = loginUiState.email,
            onValueChange = onEmailChange,
            label = stringResource(id = R.string.emailLabel),
            leadingIcon = Icons.Outlined.Email,
            leadingIconContentDescription = stringResource(id = R.string.emailLabel)
        )

        Spacer(modifier = Modifier.padding(7.dp))

        PasswordTextField(
            value = loginUiState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.passwordLabel),
            leadingIcon = Icons.Outlined.Lock,
            leadingIconContentDescription = stringResource(id = R.string.passwordLabel)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        BasicButton(
            onClick = onLogin,
            enabled = loginUiState.isLoginButtonEnabled,
            title = stringResource(id = R.string.login),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
        )

        if (!loginUiState.isLoginSuccessful) {
            Text(
                text = loginUiState.errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 10.dp),
                fontWeight = FontWeight.Bold
            )
        }

        SignUpPrompt(onNavigateToSignUp = onNavigateToSignUp)
    }
}
@Composable
private fun SignUpPrompt(onNavigateToSignUp: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(id = R.string.no_account_prompt))
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = stringResource(id = R.string.signup),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                onNavigateToSignUp()
            }
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginContent(
        loginUiState = LoginUiState(),
        onEmailChange = {},
        onPasswordChange = {},
        onLogin = {},
        onNavigateToSignUp = {}
    )
}
