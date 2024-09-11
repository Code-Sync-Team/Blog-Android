package com.example.blog.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicButton(
    onClick: () -> Unit,
    enabled: Boolean,
    title: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
            disabledContentColor = Color.Gray
        ),
        content = { Text(text = title) },
        enabled = enabled,
        modifier = modifier
    )
}


@Preview
@Composable
private fun BasicButtonPreview() {
    BasicButton(
        onClick = { },
        enabled = true,
        title = "로그인",
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(20.dp)
    )
}
