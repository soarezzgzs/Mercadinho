package com.mercadinho.saojose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaHome(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Olá, Saulo!", style = MaterialTheme.typography.headlineSmall)
        Text("Bem-vindo ao Mercado São José", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        Card {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Cartão Digital", style = MaterialTheme.typography.titleMedium)
                Text("Número do Cartão: **** **** **** 4829")
                Text("Pontos acumulados: 1.547")
                Text("Validade: 12/2026")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("Pontos: 1.547")
            Text("Cupons: 3")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Ações Rápidas", style = MaterialTheme.typography.titleMedium)
        Text("Ofertas Relâmpago: Válidas até hoje – 5 novas")
        Text("Histórico de Compras: Última compra há 2 dias")

        Spacer(modifier = Modifier.height(16.dp))
        Text("Benefícios do Cartão", style = MaterialTheme.typography.titleMedium)
        Text("✅ Desconto de 5% em todas as compras")
        Text("✅ Acumule 1 ponto a cada R$ 1 gasto")
        Text("✅ Ofertas exclusivas semanais")
    }
}
