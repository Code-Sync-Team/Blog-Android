package com.example.blog.ui.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog.ui.theme.BlogTheme

@Composable
fun EmailInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    SignUpInput(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
    )
}

@SuppressLint("StateFlowValueCalledInComposition")
@Preview
@Composable
private fun EmailInputPreview() {
    BlogTheme {
        EmailInput(
            value ="123@",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}
