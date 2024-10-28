package com.example.blog.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog.ui.theme.BlogTheme

@Composable
fun BookListRoute(
    onNavigateToBlogWrite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BookListScreen(
        onNavigateToBlogWrite = onNavigateToBlogWrite,
        modifier = modifier
    )
}

@Composable
fun BookListScreen(
    onNavigateToBlogWrite: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = onNavigateToBlogWrite,
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun BookListScreenPreview() {
    BlogTheme {
        BookListScreen(
            onNavigateToBlogWrite = {}
        )
    }
}
