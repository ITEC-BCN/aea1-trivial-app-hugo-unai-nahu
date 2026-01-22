package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel) {
    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ){
        val (image, results, goToStart) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.funnyguy),
            contentDescription = "Menu Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(200.dp)
                .border(10.dp, Color.LightGray, RoundedCornerShape(20.dp))
                .clip(
                    RoundedCornerShape(
                        20.dp
                    )
                )
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 150.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .constrainAs(results){
                    top.linkTo(image.bottom)
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                }
        ){
            Text("You earned ${viewModel.points} / ${viewModel.difficultySelected.questionsAmount} pts.")
        }

        Box(
            modifier = Modifier
                .clickable{
                    navController.navigate("Menu")
                }
                .constrainAs(goToStart){
                    top.linkTo(results.bottom)
                    start.linkTo(results.start)
                    end.linkTo(results.end)
                }
        ){
            Text("Go to start menu")
        }
    }
}