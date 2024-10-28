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

@Composable
fun CreateBlogScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: CreateBlogViewModel = hiltViewModel()

    CreateBlogScreen(
        viewModel = viewModel,
        modifier = modifier
    )
}

@Composable
private fun CreateBlogScreen(
    viewModel: CreateBlogViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        ContentInputField(
            value = uiState.title,
            onValueChange = viewModel::updateTitle,
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
            value = uiState.content,
            onValueChange = viewModel::updateContent,
            placeholder = "내용을 입력하세요.",
            modifier = Modifier
                .weight(1f)
        )

        BlogEditorBottomBar(
            onCreateBlog = { /*TODO*/ },
            onExit = { /*TODO*/ }
        )
    }
}


@Preview
@Composable
private fun CreateBlogScreenPreview() {
    CreateBlogScreen()
}
