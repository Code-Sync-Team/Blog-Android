package com.example.blog.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.blog.R
import com.example.blog.ui.components.BasicButton
import com.example.blog.ui.components.BasicTextField
import com.example.blog.ui.components.PasswordTextField
import com.example.blog.ui.theme.BlogTheme

@Composable
fun SignUpRoute(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: SignUpViewModel = hiltViewModel()
    SignUpScreen(
        viewModel = viewModel,
        navController = navController,
        modifier = modifier
    )
}

@Composable
private fun SignUpScreen(
    viewModel: SignUpViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val signUpUiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(true) {
        viewModel.signUpScreenEvent.collect { event ->
            when (event) {
                is SignUpScreenEvent.Idle -> {

                }

                is SignUpScreenEvent.Success -> {
                    // 성공 시 로그인 화면으로 이동
                    navController.popBackStack()
                }

                is SignUpScreenEvent.Error -> {
                    snackbarHostState
                        .showSnackbar(
                            message = event.message,
                            duration = SnackbarDuration.Indefinite
                        )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        SignUpContent(
            signUpUiState = signUpUiState,
            onNameChange = viewModel::updateName,
            onNickNameChange = viewModel::updateNickname,
            onEmailChange = viewModel::updateEmail,
            onPasswordChange = viewModel::updatePassword,
            isSignUpButtonEnabled = signUpUiState.isSignUpButtonEnabled,
            onSignUp = {
                viewModel.join(
                    email = signUpUiState.email,
                    password = signUpUiState.password,
                    nickname = signUpUiState.nickname,
                    name = signUpUiState.name
                )
            },
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
private fun SignUpContent(
    signUpUiState: SignUpUiState,
    onNameChange: (String) -> Unit,
    onNickNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    isSignUpButtonEnabled: Boolean,
    onSignUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = signUpUiState.name,
            onValueChange = onNameChange,
            label = stringResource(id = R.string.nameLabel),
            leadingIcon = Icons.Outlined.Person,
            leadingIconContentDescription = stringResource(id = R.string.nameLabel)
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicTextField(
            value = signUpUiState.nickname,
            onValueChange = onNickNameChange,
            label = stringResource(id = R.string.nicknameLabel),
            leadingIcon = Icons.Outlined.Person,
            leadingIconContentDescription = stringResource(id = R.string.nicknameLabel)
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicTextField(
            value = signUpUiState.email,
            onValueChange = onEmailChange,
            label = stringResource(id = R.string.emailLabel),
            leadingIcon = Icons.Outlined.Email,
            leadingIconContentDescription = stringResource(id = R.string.emailLabel)
        )

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(
            value = signUpUiState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.passwordLabel),
            leadingIcon = Icons.Outlined.Lock,
            leadingIconContentDescription = stringResource(id = R.string.passwordLabel)
        )

        Spacer(modifier = Modifier.height(20.dp))

        BasicButton(
            onClick = onSignUp,
            enabled = isSignUpButtonEnabled,
            title = stringResource(id = R.string.signup),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(20.dp)
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    BlogTheme {
        SignUpContent(
            signUpUiState = SignUpUiState(),
            onNameChange = {},
            onNickNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            isSignUpButtonEnabled = true,
            onSignUp = {})
    }
}
