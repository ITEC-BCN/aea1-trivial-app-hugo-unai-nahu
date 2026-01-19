package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ){
        val (image, gameStart, difficultyChanger) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.funnyguy),
            contentDescription = "Menu Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom, margin = 30.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .clickable{
                    viewModel.startGame()
                    navController.navigate("Game")
                }
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 20.dp,
                        bottomStart = 20.dp,
                        bottomEnd = 10.dp
                    )
                )
                .constrainAs(gameStart) {
                    top.linkTo(image.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ){
            Text("Iniciar Partida")
        }


        var show by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .clickable{ show = true }
                .clip(
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 20.dp
                    )
                )
                .constrainAs(difficultyChanger) {
                    top.linkTo(gameStart.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ){
            Text("DIFFICULTAT: " + viewModel.difficultySelected.difficulty)
            if (show) DifficultyDialog(viewModel, show, { show = false })
        }
    }
}