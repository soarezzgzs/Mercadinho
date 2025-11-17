package com.mercadinho.saojose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Seus próprios pacotes
import com.mercadinho.saojose.navigation.BottomNavigationBar
import com.mercadinho.saojose.navigation.Tela
import com.mercadinho.saojose.viewmodel.CarrinhoViewModel
import com.mercadinho.saojose.ui.login.TelaLogin
import com.mercadinho.saojose.ui.login.TelaCadastro
import com.mercadinho.saojose.ui.TelaHome
import com.mercadinho.saojose.ui.TelaMercado
import com.mercadinho.saojose.ui.TelaOfertas
import com.mercadinho.saojose.ui.TelaConfig


@Composable
fun MercadinhoApp(carrinhoViewModel: CarrinhoViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            TelaLogin(
                onLoginClick = { cpf, senha ->
                    navController.navigate(Tela.Home.rota) {
                        popUpTo("login") { inclusive = true }
                    }
                },
                onCriarContaClick = {
                    navController.navigate("cadastro")
                }
            )
        }

        composable("cadastro") {
            TelaCadastro(
                onCadastrarClick = { nome, cpf, telefone, email, senha ->
                    navController.navigate("login") {
                        popUpTo("cadastro") { inclusive = true }
                    }
                },
                onVoltarClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Tela.Home.rota) {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, carrinhoViewModel)
                }
            ) { innerPadding ->
                TelaHome(modifier = Modifier.padding(innerPadding))
            }
        }

        composable(Tela.Mercado.rota) {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, carrinhoViewModel)
                }
            ) { innerPadding ->
                TelaMercado(carrinhoViewModel, modifier = Modifier.padding(innerPadding))
            }
        }

        composable(Tela.Ofertas.rota) {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, carrinhoViewModel)
                }
            ) { innerPadding ->
                TelaOfertas(carrinhoViewModel, modifier = Modifier.padding(innerPadding))
            }
        }

        composable(Tela.Config.rota) {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, carrinhoViewModel)
                }
            ) { innerPadding ->
                TelaConfig(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
