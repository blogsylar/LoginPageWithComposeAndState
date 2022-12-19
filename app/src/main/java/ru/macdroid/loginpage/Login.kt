package ru.macdroid.loginpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Login() {

    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val showError = remember {
        mutableStateOf(false)
    }

    Scaffold() {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(listOf(Color(0xFF9575CD), Color(0xFF7E57C2)))
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Column {
                    TextField(
                        value = login.value,
                        onValueChange = {
                            login.value = it
                            showError.value = !it.isValidEmail()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        placeholder = { Text(text = "Enter Your Email") },
                        label = { Text(text = "Email") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.AccountBox, contentDescription = null) },
                        isError = showError.value
                    )
                }
            }

            Row {
                Column {
                    TextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        placeholder = { Text(text = "Enter Your Password") },
                        label = { Text(text = "Password") },
                        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null) },
                        visualTransformation = PasswordVisualTransformation()
                    )
                }

            }

            Row {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    onClick = {
                        println("click ${login.value}, ${password.value}")
                    }
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}
