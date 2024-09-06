package com.example.blog.ui.signup

import android.annotation.SuppressLint
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
fun EmailInput(
    value: String,
    onValueChange: (String) -> Unit,
    isFormatError: Boolean,
    modifier: Modifier = Modifier
) {
    SignUpInput(
        value = value,
        onValueChange = onValueChange,
        isError = isFormatError,
        supportingText = {
            if (isFormatError) {
                Text(text = stringResource(id = R.string.emailInvalidFormatMessage))
            }
        },
        label = stringResource(id = R.string.emailLabel),
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
            isFormatError = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}