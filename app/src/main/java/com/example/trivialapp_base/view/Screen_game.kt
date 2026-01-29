package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.ui.theme.cardShape
import com.example.trivialapp_base.ui.theme.lilaAccent
import com.example.trivialapp_base.ui.theme.lilaFondo
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lilaFondo)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Box(
            modifier = Modifier
                .clip(cardShape)
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Text(
                text = "${viewModel.points} pts",
                fontWeight = FontWeight.Bold
            )
        }

        LinearProgressIndicator(
            //progress = viewModel.progress,
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .height(12.dp)
                .clip(RoundedCornerShape(50)),
            color = lilaAccent,
            trackColor = Color.White
        )
        Image(
            painter = painterResource(id = R.drawable.questionman),
            contentDescription = "Question image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(250.dp)
                .clip(cardShape)
                .background(Color.White)
                .padding(8.dp)
        )

        Box(
            modifier = Modifier
                .clip(cardShape)
                .background(Color.White)
                .padding(20.dp)
        ) {
            Text(
                text = viewModel.currentQuestion.question,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            viewModel.mixedAnswers.forEachIndexed { index, answer ->
                AnswerButton(
                    text = answer,
                    color = lilaAccent
                ) {
                    if (!viewModel.questionAnswered) viewModel.answerQuestion(index)
                }
            }
        }

        if (viewModel.questionAnswered) {
            Box(
                modifier = Modifier
                    .clip(cardShape)
                    .background(Color.White)
                    .clickable { viewModel.continueRound() }
                    .padding(20.dp)
            ) {
                Text(
                    text = "Respuesta correcta:\n${viewModel.currentQuestion.correctAnswer}",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (viewModel.gameFinalized) {
            navController.navigate("Result")
        }
    }
}

@Composable
private fun AnswerButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(24.dp))
            .background(color)
            .clickable { onClick() }
            .padding(vertical = 14.dp, horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}
