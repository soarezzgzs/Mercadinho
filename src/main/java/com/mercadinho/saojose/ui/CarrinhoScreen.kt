package com.mercadinho.saojose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment // ✅ Import necessário para Alignment.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mercadinho.saojose.viewmodel.CarrinhoViewModel

@Composable
fun CarrinhoScreen(carrinhoViewModel: CarrinhoViewModel, modifier: Modifier = Modifier) {
    val itensCarrinho = carrinhoViewModel.itensCarrinho

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Text("Meu Carrinho", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(itensCarrinho) { item ->
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
                            Text(item.produto.nome, style = MaterialTheme.typography.titleMedium)
                            Text("R$ ${item.produto.preco}", style = MaterialTheme.typography.bodyMedium)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = { carrinhoViewModel.removerProduto(item.produto) }) {
                                Icon(Icons.Filled.Remove, contentDescription = "Remover")
                            }
                            Text("${item.quantidade}", style = MaterialTheme.typography.bodyLarge)
                            IconButton(onClick = { carrinhoViewModel.adicionarProduto(item.produto) }) {
                                Icon(Icons.Filled.Add, contentDescription = "Adicionar")
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { carrinhoViewModel.finalizarCompra() }) {
                Text("Finalizar Compra")
            }
            Button(onClick = { carrinhoViewModel.limparCarrinho() }) {
                Text("Limpar Carrinho")
            }
        }
    }
}
