package com.example.trivialapp_base.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun NavigationController(navController: NavController, viewModel: GameViewModel){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Routes.MenuScreen.route
    ) {
        composable(Routes.LaunchScreen.route) { SplashScreen(navController) }
        composable(Routes.MenuScreen.route) { MenuScreen(navController, viewModel) }
        composable(Routes.GameScreen.route) { GameScreen(navController, viewModel) }
        composable(Routes.ResultScreen.route) { ResultScreen(navController, viewModel) }
    }
}