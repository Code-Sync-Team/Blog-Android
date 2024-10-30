package com.example.blog.ui.createblog

import android.util.Log
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

data class CreatePostUiState(
    val title: String = "",
    val content: String = "",
    val isCreateButtonEnabled: Boolean = title.isNotEmpty() && content.isNotEmpty()
)

@HiltViewModel
class CreateBlogViewModel @Inject constructor(
    private val blogRepository: BlogRepository
) : ViewModel() {
    private val _createPostUiState = MutableStateFlow(CreatePostUiState())
    val createPostUiState: StateFlow<CreatePostUiState> = _createPostUiState.asStateFlow()

    private fun updateCreateButtonState() {
        val title = _createPostUiState.value.title
        val content = _createPostUiState.value.content

        _createPostUiState.update { currentState ->
            currentState.copy(
                isCreateButtonEnabled = title.isNotEmpty() && content.isNotEmpty()
            )
        }
    }

    fun updateTitle(title: String) {
        _createPostUiState.value = _createPostUiState.value.copy(title = title)
        updateCreateButtonState()
    }

    fun updateContent(content: String) {
        _createPostUiState.value = _createPostUiState.value.copy(content = content)
        updateCreateButtonState()
    }

    fun createPost() {
        val title = _createPostUiState.value.title
        val content = _createPostUiState.value.content

        viewModelScope.launch {
            blogRepository.createPost(
                title = title,
                content = content
            ).fold(
                onSuccess = {
                    Log.d("결과", "createPost: $it")
                },
                onFailure = {
                    Log.d("결과", "createPost: $it")
                }
            )
        }
    }

}
