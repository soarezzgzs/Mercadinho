package com.mercadinho.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

@Composable
fun MercadinhoApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            TelaLogin(
                onLoginClick = { cpf, senha ->
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onCriarContaClick = {
                    navController.navigate("cadastro")
                }
            )
        }

        composable("home") {
            // Aqui você pode chamar TelaHome futuramente
        }
    }
}

// Para iOS
fun MainViewController() = ComposeUIViewController { MercadinhoApp() }
