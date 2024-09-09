package com.example.blog.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.blog.R
import com.example.blog.ui.components.BasicTextField

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier
) {
    val viewModel: LoginViewModel = hiltViewModel()
    LoginScreen(
        viewModel = viewModel,
        modifier = modifier
    )
}

@Composable
private fun LoginScreen(
    viewModel: LoginViewModel,
    modifier: Modifier = Modifier,
) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        LoginContent(
            email = email,
            password = password,
            onEmailChange = viewModel::updateEmail,
            onPasswordChange = viewModel::updatePassword,
            onLogin = { viewModel.login(email, password) },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun LoginContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BasicTextField(
            value = email,
            onValueChange = onEmailChange,
            label = stringResource(id = R.string.emailLabel)
        )

        Spacer(modifier = Modifier.padding(7.dp))

        BasicTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.passwordLabel),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = onLogin) {
            Text(
                text = stringResource(id = R.string.login)
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginContent(
        email = "",
        password = "",
        onEmailChange = {},
        onPasswordChange = {},
        onLogin = {}
    )
}
