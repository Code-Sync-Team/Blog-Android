package com.example.blog.ui.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog.R
import com.example.blog.ui.theme.BlogTheme

@Composable
fun NickNameInput(
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

@Preview
@Composable
private fun NickNameInputPreview() {
    BlogTheme {
        NickNameInput(
            value = "asdff",
            onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}
