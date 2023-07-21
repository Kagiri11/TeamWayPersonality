package com.maina.personalityapp.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationRow(isAtStart: Boolean = false, isAtEnd: Boolean = true, onNextClick:()-> Unit,onPreviousClick:()-> Unit){
    Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround) {
        Log.d("PersonalityApp", "State here atStart: $isAtStart atEnd: $isAtEnd")
        when{
            isAtStart -> {
                NavigationButton(isEnabled = false, text = "Previous", onClick = onPreviousClick)
                NavigationButton(isEnabled = true, text = "Next", onClick = onNextClick)
            }
            isAtEnd -> {
                NavigationButton(isEnabled = true, text = "Previous", onClick = onPreviousClick)
                NavigationButton(isEnabled = true, text = "Get Result", onClick = onNextClick)
            }
            else -> {
                NavigationButton(isEnabled = true, text = "Previous", onPreviousClick)
                NavigationButton(isEnabled = true, text = "Next", onClick = onNextClick)
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