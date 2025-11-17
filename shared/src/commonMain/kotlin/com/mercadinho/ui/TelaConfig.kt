package com.mercadinho.saojose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mercadinho.saojose.viewmodel.UsuarioViewModel

@Composable
fun TelaConfig(
    modifier: Modifier = Modifier,
    usuarioViewModel: UsuarioViewModel = viewModel(),
    onLogoutClick: () -> Unit = {}
) {
    var notificacoesAtivas by remember { mutableStateOf(true) }
    val usuario = usuarioViewModel.usuario.value

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Parte superior: Informações do usuário
        Column {
            Text(usuario.nome, style = MaterialTheme.typography.titleLarge)
            Text(usuario.email, style = MaterialTheme.typography.bodyMedium)
            if (usuario.clienteVip) {
                Text("Cliente VIP", style = MaterialTheme.typography.labelMedium)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            InfoCard("Pontos", usuario.pontos.toString(), modifier = Modifier.weight(1f))
            InfoCard("Compras", usuario.compras.toString(), modifier = Modifier.weight(1f))
            InfoCard("Cupons", usuario.cupons.toString(), modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Seção: Conta
        SectionTitle("Conta")
        InfoItem("Nome", usuario.nome)
        InfoItem("CPF", usuario.cpf)
        InfoItem("Email", usuario.email)
        InfoItem("Telefone", usuario.telefone)
        InfoItem("Senha", "Alterar senha")

        Spacer(modifier = Modifier.height(24.dp))

        // Seção: Pagamento e Endereço
        SectionTitle("Pagamento e Endereço")
        InfoItem("Formas de Pagamento", "Adicionar cartão")
        InfoItem("Endereço", "Rua das Flores, 123") // futuramente pode vir do ViewModel

        Spacer(modifier = Modifier.height(24.dp))

        // Seção: Notificações
        SectionTitle("Notificações")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Notificações de ofertas", style = MaterialTheme.typography.bodyLarge)
            Switch(checked = notificacoesAtivas, onCheckedChange = { notificacoesAtivas = it })
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botão de sair
        Button(
            onClick = {
                usuarioViewModel.logout()
                onLogoutClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.ExitToApp, contentDescription = "Sair")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Sair da sua conta")
        }
    }
}

@Composable
fun InfoCard(label: String, valor: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(horizontal = 4.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = valor, style = MaterialTheme.typography.titleMedium)
            Text(text = label, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun SectionTitle(titulo: String) {
    Text(
        text = titulo,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun InfoItem(label: String, valor: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = label, style = MaterialTheme.typography.labelSmall)
        Text(text = valor, style = MaterialTheme.typography.bodySmall)
    }
}
