package com.example.blog.ui.createblog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CreatePostRoute(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: CreateBlogViewModel = hiltViewModel()

    CreateBlogScreen(
        viewModel = viewModel,
        onNavigateToMain = {
            navController.popBackStack()
        },
        modifier = modifier
    )
}

@Composable
private fun CreateBlogScreen(
    viewModel: CreateBlogViewModel,
    onNavigateToMain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val createPostUiState by viewModel.createPostUiState.collectAsState()

    CreatePostContent(
        createPostUiState = createPostUiState,
        onTitleChange = viewModel::updateTitle,
        onContentChange = viewModel::updateContent,
        onCreatePost = viewModel::createPost,
        onExit = onNavigateToMain,
        modifier = modifier
    )
}

@Composable
fun CreatePostContent(
    createPostUiState: CreatePostUiState,
    onTitleChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
    onExit: () -> Unit,
    onCreatePost: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(top = 10.dp)
            .fillMaxSize()
    ) {
        ContentInputField(
            value = createPostUiState.title,
            onValueChange = onTitleChange,
            placeholder = "제목은 입력해주세요.",
            singleLine = true
        )

        HorizontalDivider(
            modifier = Modifier
                .width(100.dp)
                .padding(start = 15.dp),
            thickness = 2.dp,
            color = Color.Black,
        )

        ContentInputField(
            value = createPostUiState.content,
            onValueChange = onContentChange,
            placeholder = "내용을 입력하세요.",
            modifier = Modifier
                .weight(1f)
        )

        BlogEditorBottomBar(
            onCreateBlog = onCreatePost,
            onExit = onExit,
            isCreateButtonEnabled = createPostUiState.isCreateButtonEnabled
        )
    }
}

@Preview
@Composable
private fun CreateBlogScreenPreview() {
    CreatePostContent(
        createPostUiState = CreatePostUiState(),
        onTitleChange = {},
        onContentChange = {},
        onCreatePost = {},
        onExit = {}
    )
}
