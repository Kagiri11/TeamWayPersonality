package com.maina.personalityapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationRow(isAtStart: Boolean = false, isAtEnd: Boolean = true){
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround) {
        when{
            isAtStart -> {
                NavigationButton(isEnabled = false, text = "Previous"){}
                NavigationButton(isEnabled = true, text = "Next"){}
            }
            isAtEnd -> {
                NavigationButton(isEnabled = true, text = "Previous"){}
                NavigationButton(isEnabled = true, text = "Get Result"){}
            }
            else -> {
                NavigationButton(isEnabled = true, text = "Previous"){}
                NavigationButton(isEnabled = true, text = "Next"){}
            }
        }
    }
}

@Composable
fun NavigationButton(isEnabled: Boolean, text: String, onClick: () -> Unit){
    Button(enabled = isEnabled,onClick = onClick) {
        Text(text = text)
    }
}