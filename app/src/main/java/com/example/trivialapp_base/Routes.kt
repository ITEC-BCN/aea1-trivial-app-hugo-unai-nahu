package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object LaunchScreen: Routes("Splash")
    object MenuScreen: Routes("Menu")
    object GameScreen: Routes("Game")
    object ResultScreen: Routes("Result")
}