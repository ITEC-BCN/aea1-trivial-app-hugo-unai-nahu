package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    val lilaFondo = Color(0xFFF3E5F5) // Lila muy claro para el fondo
    val lilaBotones = Color(0xFFB39DDB) // Lila para los botones

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lilaFondo),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        // Imagen con borde redondeado y fondo blanco
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = "Menu Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        // Botón "Iniciar Partida"
        Box(
            modifier = Modifier
                .clickable {
                    viewModel.startGame()
                    navController.navigate("Game")
                }
                .clip(RoundedCornerShape(24.dp))
                .background(lilaBotones)
                .fillMaxWidth(0.8f)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Iniciar Partida",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        // Botón "Dificultad"
        var show by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .clickable { show = true }
                .clip(RoundedCornerShape(24.dp))
                .background(lilaBotones)
                .fillMaxWidth(0.8f)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "DIFICULTAD: ${viewModel.difficultySelected.difficulty}",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        if (show) DifficultyDialog(viewModel, show, { show = false })
    }
}
