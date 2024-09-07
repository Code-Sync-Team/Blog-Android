package com.example.blog.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blog.R

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier
) {
    LoginScreen(
        modifier = modifier
    )
}

@Composable
private fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        LoginContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
fun LoginContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = "",
            onValueChange = {}
        )

        Spacer(modifier = Modifier.padding(7.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {}
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.login)
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}
