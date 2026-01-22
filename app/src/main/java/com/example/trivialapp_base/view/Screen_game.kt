package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.ui.theme.Purple777
import com.example.trivialapp_base.ui.theme.PurpleBack
import com.example.trivialapp_base.ui.theme.PurpleFront
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    Image(
        painter = painterResource(id = R.drawable.gamebackground),
        contentDescription = "Background",
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxSize()
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (currentPoints, timeBar, image, answersBox, question, firstAnswer, secondAnswer, thirdAnswer, fourthAnswer, correctAnswer) = createRefs()

        Box(
            modifier = Modifier
                .background(PurpleBack)
                .border(5.dp, Purple777)
                .padding(20.dp)
                .constrainAs(currentPoints){
                    top.linkTo(parent.top, margin = 50.dp)
                    end.linkTo(parent.end, margin = 50.dp)
                }
        ){
            Text("${viewModel.points} pts.")
        }

        LinearProgressIndicator(
            //progress = { progressStatus },
            modifier = Modifier
                .padding(25.dp, 10.dp)
                .height(25.dp)
                .border(5.dp, Purple777, RoundedCornerShape(20.dp))
                .width(500.dp)
                .clip(RoundedCornerShape(20.dp) )
                .constrainAs(timeBar){
                    top.linkTo(currentPoints.bottom)
                    bottom.linkTo(image.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            color = PurpleFront,
            trackColor = PurpleBack,
            strokeCap = StrokeCap.Butt
        )

        Image(
            painter = painterResource(id = R.drawable.questionman),
            contentDescription = "Question Men Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .border(10.dp, Purple777, RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 120.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Box(
            modifier = Modifier
                .background(PurpleFront)
                .border(5.dp, Purple777)
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
                .background(PurpleBack)
                .border(5.dp, Purple777)
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
                .background(PurpleFront)
                .padding(10.dp)
                .clip( RoundedCornerShape(10.dp) )
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
                .background(PurpleFront)
                .padding(10.dp)
                .clip( RoundedCornerShape(10.dp) )
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
                .background(PurpleFront)
                .padding(10.dp)
                .clip( RoundedCornerShape(10.dp) )
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
                .background(PurpleFront)
                .padding(10.dp)
                .clip( RoundedCornerShape(10.dp) )
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
                    .background(PurpleBack)
                    .border(5.dp, Purple777)
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