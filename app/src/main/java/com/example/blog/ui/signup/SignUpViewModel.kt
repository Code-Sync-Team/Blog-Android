package com.example.blog.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blog.data.repository.BlogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SignUpUiState(
    val email: String = "",
    val password: String = "",
    val nickname: String = "",
    val name: String = "",
) {
    private val emailREGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

    val isEmailFormatError = email.isNotEmpty() && !email.matches(Regex(emailREGEX))

    private val areFieldsFilled =
        nickname.isNotEmpty() && email.isNotEmpty() &&
                password.isNotEmpty() && name.isNotEmpty()

    private val areFieldsValid = !isEmailFormatError

    val isSignUpButtonEnabled = areFieldsFilled && areFieldsValid
}

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val blogRepository: BlogRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())

    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun join(
        email: String,
        password: String,
        nickname: String,
        name: String
    ) {
        viewModelScope.launch {
            blogRepository.join(
                email = email,
                password = password,
                nickname = nickname,
                name = name
            ).fold(
                onSuccess = {

                },
                onFailure = {

                }
            )
        }
    }

    fun updateEmail(email: String) {
        _uiState.update { currentState ->
            currentState.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy(password = password)
        }
    }

    fun updateNickname(nickname: String) {
        _uiState.update { currentState ->
            currentState.copy(nickname = nickname)
        }
    }

    fun updateName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(name = name)
        }
    }

}
