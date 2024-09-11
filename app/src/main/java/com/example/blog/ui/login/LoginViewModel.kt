package com.example.blog.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blog.data.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val errorMessage: String = "",
    val isLoginButtonEnabled: Boolean = false,
    val isLoginSuccessful: Boolean = false
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val blogRepository: BlogRepository
) : ViewModel() {

    private val _loginUiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val loginUiState = _loginUiState.asStateFlow()

    private fun validateInputs() {
        val isEmailValid = _loginUiState.value.email.isNotBlank()
        val isPasswordValid = _loginUiState.value.password.isNotBlank()

        _loginUiState.update { currentState ->
            currentState.copy(isLoginButtonEnabled = isEmailValid && isPasswordValid)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            blogRepository.login(email = email, password = password)
                .fold(
                    onSuccess = {
                        _loginUiState.update { currentState ->
                            currentState.copy(isLoginSuccessful = true)
                        }
                    },
                    onFailure = {
                        _loginUiState.update { currentState ->
                            currentState.copy(errorMessage = "로그인에 실패하였습니다.")
                        }
                    }
                )
        }
    }

    fun updateEmail(email: String) {
        _loginUiState.update { currentState ->
            currentState.copy(email = email)
        }
        validateInputs()
    }

    fun updatePassword(password: String) {
        _loginUiState.update { currentState ->
            currentState.copy(password = password)
        }
        validateInputs()
    }
}
