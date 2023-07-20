package com.maina.personalityapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maina.personalityapp.MainViewModel
import com.maina.personalityapp.component.NavigationRow
import com.maina.personalityapp.component.QuestionCardComponent
import org.koin.androidx.compose.getViewModel

@Composable
fun QuestionScreen(mainViewModel: MainViewModel = getViewModel()) {
    val question = mainViewModel.currentQuestion.observeAsState().value
    val questionnaireProgress = mainViewModel.questionnaireProgress.observeAsState().value ?: 0F
    val trait = mainViewModel.trait.observeAsState().value
    val choiceSelected = remember { mutableStateOf("") }
    Log.d("PersonalityApp", "Questionnaire progress $questionnaireProgress")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
        ) {
        when(trait == null){
            true -> {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(10.dp), progress = questionnaireProgress
                )
                Spacer(modifier = Modifier.height(100.dp))
                question?.let {
                    QuestionCardComponent(
                        question= it,
                        selectedChoice = choiceSelected.value,
                        onChoiceSelected = { answer ->
                            mainViewModel.answerQuestion(answer = answer, questionId = question.id)
                            choiceSelected.value = answer
                        }
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))
                NavigationRow(
                    isAtStart = questionnaireProgress.isAtStart(),
                    isAtEnd = questionnaireProgress.isAtEnd(),
                    onNextClick = {
                        if (questionnaireProgress.isAtEnd()) {
                            mainViewModel.completeTest()
                        } else {
                            mainViewModel.moveToNextQuestion()
                        }
                    },
                    onPreviousClick = { mainViewModel.moveToPreviousQuestion() }
                )
            }
            false -> {
                Text(text = "You have an $trait personality", style = TextStyle(color = Color.White))
            }
        }
    }
}

fun Float.isAtStart() = this == 0F
fun Float.isAtEnd() = this == 0.6666667F || this == 1F

@Preview
@Composable
fun QuestionScreenPreview() {
    QuestionScreen()
}