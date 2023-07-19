package com.maina.personalityapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChoiceComponent() {
    Row(
        modifier = Modifier.padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        RadioButton(selected = true, onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Choice One")
    }
}

@Preview
@Composable
fun ChoiceComponentPreview() {
    ChoiceComponent()
}