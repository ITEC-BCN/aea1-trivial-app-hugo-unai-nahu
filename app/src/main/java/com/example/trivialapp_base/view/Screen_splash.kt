package com.example.trivialapp_base.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    navController.navigate("Menu")
}