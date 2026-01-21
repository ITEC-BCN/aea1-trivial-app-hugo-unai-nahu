package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (currentPoints, image, answersBox, question, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, correctAnswer) = createRefs()

        Box(
            modifier = Modifier
                .background(Color.White)
                .border(5.dp, Color.LightGray)
                .padding(20.dp)
                .constrainAs(currentPoints){
                    top.linkTo(parent.top, margin = 40.dp)
                    end.linkTo(parent.end, margin = 50.dp)
                }
        ){
            Text("${viewModel.points} pts.")
        }

        Image(
            painter = painterResource(id = R.drawable.funnyguy),
            contentDescription = "Menu Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .border(10.dp, Color.LightGray, CircleShape)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            modifier = Modifier
                .background(Color.White)
                .border(5.dp, Color.LightGray)
                .padding(20.dp)
                .constrainAs(question){
                    top.linkTo(image.bottom, margin = 40.dp)
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                }
        ){
            Text(viewModel.currentQuestion.question, textAlign = TextAlign.Center)
        }

        Box(
            modifier = Modifier
                .size(height = 130.dp, width = 230.dp)
                .background(Color.Black)
                .border(5.dp, Color.LightGray)
                .constrainAs(answersBox){
                    top.linkTo(question.bottom, margin = 20.dp)
                    start.linkTo(question.start)
                    end.linkTo(question.end)
                }
        )
        Box(
            modifier = Modifier
                .size(height = 50.dp, width = 100.dp)
                .clickable{
                    if (!viewModel.questionAnsered) viewModel.answerQuestion(0)
                }
                .background(Color.LightGray)
                .padding(10.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .constrainAs(firstAnswer){
                    top.linkTo(answersBox.top, margin = 10.dp)
                    start.linkTo(answersBox.start, margin = 10.dp)
                }
        ){ Text(viewModel.mixedAnswers[0], textAlign = TextAlign.Center) }
        Box(
            modifier = Modifier
                .size(height = 50.dp, width = 100.dp)
                .clickable{
                    if (!viewModel.questionAnsered) viewModel.answerQuestion(1)
                }
                .background(Color.LightGray)
                .padding(10.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .constrainAs(secondAnswer){
                    top.linkTo(answersBox.top, margin = 10.dp)
                    end.linkTo(answersBox.end, margin = 10.dp)
                    start.linkTo(firstAnswer.end, margin = 10.dp)
                }
        ){ Text(viewModel.mixedAnswers[1], textAlign = TextAlign.Center) }
        Box(
            modifier = Modifier
                .size(height = 50.dp, width = 100.dp)
                .clickable{
                    if (!viewModel.questionAnsered) viewModel.answerQuestion(2)
                }
                .background(Color.LightGray)
                .padding(10.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .constrainAs(thirdAnswer){
                    top.linkTo(firstAnswer.bottom, margin = 10.dp)
                    start.linkTo(answersBox.start, margin = 10.dp)
                    bottom.linkTo(answersBox.bottom, margin = 10.dp)
                }
        ){ Text(viewModel.mixedAnswers[2], textAlign = TextAlign.Center) }
        Box(
            modifier = Modifier
                .size(height = 50.dp, width = 100.dp)
                .clickable{
                    if (!viewModel.questionAnsered) viewModel.answerQuestion(3)
                }
                .background(Color.LightGray)
                .padding(10.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .constrainAs(fourthAnswer){
                    top.linkTo(secondAnswer.bottom, margin = 10.dp)
                    start.linkTo(thirdAnswer.end, margin = 10.dp)
                    end.linkTo(answersBox.end, margin = 10.dp)
                    bottom.linkTo(answersBox.bottom, margin = 10.dp)
                }
        ){ Text(viewModel.mixedAnswers[3], textAlign = TextAlign.Center) }

        if (viewModel.questionAnsered){
            Box(
                modifier = Modifier
                    .clickable{
                        viewModel.continueRound()
                    }
                    .background(Color.White)
                    .border(5.dp, Color.LightGray)
                    .padding(20.dp)
                    .constrainAs(correctAnswer){
                        top.linkTo(answersBox.bottom, margin = 30.dp)
                        start.linkTo(answersBox.start)
                        end.linkTo(answersBox.end)
                    }
            ){
                Text(
                    "The correct answer was... \n ${viewModel.currentQuestion.correctAnswer}",
                    textAlign =  TextAlign.Center
                )
            }
        }

        if (viewModel.gameFinalized) navController.navigate("Result")
    }
}