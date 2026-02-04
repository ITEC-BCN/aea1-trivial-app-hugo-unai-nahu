package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.ui.theme.Purple777
import com.example.trivialapp_base.ui.theme.PurpleBack
import com.example.trivialapp_base.ui.theme.cardShape
import com.example.trivialapp_base.ui.theme.lilaAccent
import com.example.trivialapp_base.ui.theme.lilaFondo
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(lilaFondo)
    ) {
        val (currentPoints, timeBar, image, answersBox, question, answer) = createRefs()

        Box(
            modifier = Modifier
                .clip(cardShape)
                .background(PurpleBack)
                .border(5.dp, lilaAccent, cardShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .constrainAs(currentPoints) {
                    top.linkTo(parent.top, margin = 50.dp)
                    end.linkTo(parent.end, margin = 50.dp)
                }
        ){
            Text("${viewModel.points} pts.",
                fontWeight = FontWeight.Bold
            )
        }

        LinearProgressIndicator(
        progress = { 1f - viewModel.remindingTime },
        modifier = Modifier
                        .padding(25.dp, 10.dp)
                        .height(25.dp)
                        .border(5.dp, lilaAccent, cardShape)
                        .width(500.dp)
                        .clip(cardShape)
                        .constrainAs(timeBar) {
                            top.linkTo(currentPoints.bottom)
                            bottom.linkTo(image.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
        color = Purple777,
        trackColor = PurpleBack,
        strokeCap = StrokeCap.Butt,
        )

        Image(
            painter = painterResource(id = R.drawable.questionman),
            contentDescription = "Question Men Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .border(10.dp, lilaAccent, cardShape)
                .clip(cardShape)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 250.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            modifier = Modifier
                .clip(cardShape)
                .background(Color.White)
                .border(5.dp, lilaAccent, cardShape)
                .padding(20.dp)
                .constrainAs(question) {
                    top.linkTo(image.bottom, margin = 20.dp)
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                }
        ){
            Text(
                text = viewModel.currentQuestion.question,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Column (
            modifier = Modifier.constrainAs(answersBox) {
                top.linkTo(question.bottom)
                start.linkTo(question.start)
                end.linkTo(question.end)
            }
        ) {
            viewModel.mixedAnswers.forEachIndexed { index, answer ->
                AnswerButton(
                    text = answer,
                    color = lilaAccent
                ) {
                    if (!viewModel.questionAnswered) viewModel.answerQuestion(viewModel.mixedAnswers[index])
                }
            }
        }
        if (viewModel.questionAnswered) {
            Box(
                modifier = Modifier
                    .clip(cardShape)
                    .background(Color.White)
                    .padding(20.dp)
                    .constrainAs(answer){
                        top.linkTo(answersBox.bottom)
                        start.linkTo(question.start)
                        end.linkTo(question.end)
                    }
            ) {
                Text(
                    text = "Respuesta correcta:\n${viewModel.currentQuestion.correctAnswer}",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier.fillMaxSize()
                    .clickable(onClick = {

                        if (viewModel.gameFinalized) {
                            navController.navigate("Result")
                        }
                        else{
                            viewModel.continueRound()
                        }
                    })
            )
        }
    }
}

@Composable
private fun AnswerButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Spacer(Modifier.size(10.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .clip(cardShape)
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
