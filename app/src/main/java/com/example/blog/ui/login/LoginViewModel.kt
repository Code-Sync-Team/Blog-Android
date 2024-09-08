package com.example.blog.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blog.data.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface LoginUiState {
    data object Loading : LoginUiState
    data object Success : LoginUiState
    data class Error(val message: String) : LoginUiState
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val blogRepository: BlogRepository
) : ViewModel() {

    private val _loginUiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.Loading)
    val loginUiState = _loginUiState.asStateFlow()

    private val _email: MutableStateFlow<String> = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password: MutableStateFlow<String> = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            blogRepository.login(email = "test@gmail.com", password = "test")
                .fold(
                    onSuccess = {
                        _loginUiState.value = LoginUiState.Success
                        Log.d("결과", "login: onSuccess")
                    },
                    onFailure = {
                        _loginUiState.value = LoginUiState.Error(it.message ?: "")
                    }
                )
        }
    }

    fun updateEmail(email: String) {
        _email.value = email
    }

    fun updatePassword(password: String) {
        _password.value = password
    }
}
