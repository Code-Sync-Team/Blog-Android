package com.example.blog.ui.createblog

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class CreateBlogUiState(
    val title: String = "",
    val content: String = ""
)

@HiltViewModel
class CreateBlogViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(CreateBlogUiState())
    val uiState: StateFlow<CreateBlogUiState> = _uiState.asStateFlow()

    fun updateTitle(title: String) {
        _uiState.value = _uiState.value.copy(title = title)
    }

    fun updateContent(content: String) {
        _uiState.value = _uiState.value.copy(content = content)
    }

}
