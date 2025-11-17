package com.mercadinho.saojose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import com.mercadinho.saojose.viewmodel.CarrinhoViewModel


// Definição das telas com ícone e label
sealed class Tela(val rota: String, val icone: ImageVector, val label: String) {
    object Home : Tela("home", Icons.Filled.Home, "Home")
    object Mercado : Tela("mercado", Icons.Filled.ShoppingCart, "Mercado")
    object Ofertas : Tela("ofertas", Icons.Filled.Star, "Ofertas")
    object Config : Tela("config", Icons.Filled.Settings, "Configurações")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavController, carrinhoViewModel: CarrinhoViewModel) {
    val items = listOf(
        Tela.Home,
        Tela.Mercado,
        Tela.Ofertas,
        Tela.Config
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { tela ->
            val isSelected = currentRoute == tela.rota
            val quantidade = carrinhoViewModel.contador.value

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(tela.rota) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (tela is Tela.Mercado && quantidade > 0) {
                        BadgedBox(
                            badge = {
                                Badge {
                                    Text("$quantidade")
                                }
                            }
                        ) {
                            Icon(
                                imageVector = tela.icone,
                                contentDescription = tela.label
                            )
                        }
                    } else {
                        Icon(
                            imageVector = tela.icone,
                            contentDescription = tela.label
                        )
                    }
                },
                label = {
                    Text(text = tela.label)
                },
                alwaysShowLabel = true
            )
        }
    }
}
