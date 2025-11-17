package com.mercadinho.saojose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mercadinho.saojose.viewmodel.CarrinhoViewModel
import com.mercadinho.saojose.model.Produto // ✅ Import correto do modelo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaMercado(
    carrinhoViewModel: CarrinhoViewModel,
    modifier: Modifier = Modifier
) {
    val produtos = listOf(
        Produto("Arroz 5kg", 25.90),
        Produto("Feijão 1kg", 8.50),
        Produto("Macarrão 500g", 4.20)
    )

    var mostrarCarrinho by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mercado") },
                actions = {
                    IconButton(onClick = { mostrarCarrinho = !mostrarCarrinho }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrinho")
                    }
                }
            )
        }
    ) { padding ->
        val contentModifier = modifier
            .padding(padding)
            .padding(16.dp)

        if (mostrarCarrinho) {
            CarrinhoScreen(carrinhoViewModel, contentModifier)
        } else {
            LazyColumn(modifier = contentModifier) {
                items(produtos) { produto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(produto.nome, style = MaterialTheme.typography.titleMedium)
                                Text("R$ ${produto.preco}", style = MaterialTheme.typography.bodyMedium)
                            }
                            Button(onClick = { carrinhoViewModel.adicionarProduto(produto) }) {
                                Text("Adicionar")
                            }
                        }
                    }
                }
            }
        }
    }
}
