package com.mercadinho.saojose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mercadinho.saojose.model.Produto
import com.mercadinho.saojose.viewmodel.CarrinhoViewModel

@Composable
fun TelaOfertas(
    carrinhoViewModel: CarrinhoViewModel,
    modifier: Modifier = Modifier
) {
    val ofertas = listOf(
        Produto("Arroz 5kg", 19.99),
        Produto("Feijão 1kg", 7.49),
        Produto("Óleo 900ml", 6.99),
        Produto("Café 500g", 12.90)
    )

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Ofertas da Semana",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(ofertas) { produto ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = produto.nome, fontSize = 18.sp)
                        Text(
                            text = "R$ ${produto.preco}",
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = {
                            carrinhoViewModel.adicionarProduto(produto)
                        }) {
                            Text("Adicionar ao carrinho")
                        }
                    }
                }
            }
        }
    }
}
