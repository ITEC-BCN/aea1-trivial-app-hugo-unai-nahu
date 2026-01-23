package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.trivialapp_base.model.DifficultyProvider
import com.example.trivialapp_base.ui.theme.Purple777
import com.example.trivialapp_base.ui.theme.PurpleBack
import com.example.trivialapp_base.ui.theme.PurpleFront
import com.example.trivialapp_base.ui.theme.PurpleGrey40
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun DifficultyDialog(viewModel: GameViewModel, show: Boolean, onDismiss: () -> Unit){
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ){
        if (show){
            ConstraintLayout (
                modifier = Modifier
                    .clip(shape =  RoundedCornerShape(20.dp))
                    .background(PurpleBack)
                    .padding(5.dp)
                    .border(width = 10.dp, color = Purple777, shape = RoundedCornerShape(20.dp))
            ) {
                val (difficulty, easy, midl, hard) = createRefs()

                Box(
                    modifier = Modifier
                        .constrainAs(difficulty){
                            top.linkTo(parent.top, margin = 20.dp)
                            start.linkTo(parent.start, margin = 20.dp)
                            end.linkTo(parent.end, margin = 20.dp)
                        }
                ){
                    Text("DIFICULTAT ACTUAL: " + viewModel.difficultySelected.difficulty)
                }

                Box(
                    Modifier.clickable{
                        viewModel.setDifficulty(DifficultyProvider.easy())
                        onDismiss()
                    }
                        .clip(
                            RoundedCornerShape(
                                topStart = 15.dp,
                                topEnd = 15.dp,
                                bottomStart = 15.dp,
                                bottomEnd = 15.dp
                            )
                        )
                        .background(PurpleFront)
                        .padding(10.dp)
                        .constrainAs(easy){
                            top.linkTo(difficulty.bottom, margin = 20.dp)
                            start.linkTo(difficulty.start)
                            end.linkTo(difficulty.end)
                        }
                ){
                    Text("Seleccionar Facil", color = Color.Green)
                }
                Spacer(Modifier.padding(20.dp))
                Box(
                    Modifier.clickable{
                        viewModel.setDifficulty(DifficultyProvider.midl())
                        onDismiss()
                    }
                        .clip(
                            RoundedCornerShape(
                                topStart = 15.dp,
                                topEnd = 15.dp,
                                bottomStart = 15.dp,
                                bottomEnd = 15.dp
                            )
                        )
                        .background(PurpleFront)
                        .padding(10.dp)
                        .constrainAs(midl){
                            top.linkTo(easy.bottom, margin = 10.dp)
                            start.linkTo(difficulty.start)
                            end.linkTo(difficulty.end)
                        }
                ){
                    Text("Seleccionar Mitja", color = Color.Yellow)
                }
                Spacer(Modifier.padding(20.dp))
                Box(
                    Modifier.clickable{
                        viewModel.setDifficulty(DifficultyProvider.hard())
                        onDismiss()
                    }
                        .clip(
                            RoundedCornerShape(
                                topStart = 15.dp,
                                topEnd = 15.dp,
                                bottomStart = 15.dp,
                                bottomEnd = 15.dp
                            )
                        )
                        .background(PurpleFront)
                        .padding(10.dp)
                        .constrainAs(hard){
                            top.linkTo(midl.bottom, margin = 10.dp)
                            bottom.linkTo(parent.bottom, margin = 20.dp)
                            start.linkTo(difficulty.start)
                            end.linkTo(difficulty.end)
                        }
                ){
                    Text("Seleccionar Dificil \uD83D\uDC80")
                }
            }
        }
    }

}
