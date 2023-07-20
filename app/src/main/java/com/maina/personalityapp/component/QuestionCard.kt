package com.maina.personalityapp.component

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maina.domain.models.Question

@Composable
fun QuestionCardComponent(question: Question, selectedChoice: String,onChoiceSelected: (String) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .wrapContentHeight(),
        shape = RoundedCornerShape(5)
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Text(text = question.question)
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                question.choices.forEach {
                    ChoiceComponent(
                        choice = it.choice,
                        selectedChoice = selectedChoice,
                        onChoiceSelected = onChoiceSelected
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun QuestionCardComponentPreview() {
    QuestionCardComponent(Question(0, listOf(), ""),"", {})
}