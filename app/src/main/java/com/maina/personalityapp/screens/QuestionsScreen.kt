package com.maina.personalityapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maina.personalityapp.MainViewModel
import com.maina.personalityapp.component.NavigationRow
import com.maina.personalityapp.component.QuestionCardComponent
import org.koin.androidx.compose.getViewModel

@Composable
fun QuestionScreen(mainViewModel: MainViewModel = getViewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        LinearProgressIndicator(modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(10.dp), progress = 0.5f)
        Spacer(modifier = Modifier.height(100.dp))
        QuestionCardComponent()
        Spacer(modifier = Modifier.height(100.dp))
        NavigationRow()
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    QuestionScreen()
}