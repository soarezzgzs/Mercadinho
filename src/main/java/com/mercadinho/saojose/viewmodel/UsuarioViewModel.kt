package com.mercadinho.saojose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

// Modelo de dados do usuário
data class Usuario(
    val nome: String = "",
    val cpf: String = "",
    val email: String = "",
    val telefone: String = "",
    val pontos: Int = 0,
    val compras: Int = 0,
    val cupons: Int = 0,
    val clienteVip: Boolean = false
)

class UsuarioViewModel : ViewModel() {

    // Estado reativo do usuário
    private val _usuario = mutableStateOf(Usuario())
    val usuario: State<Usuario> get() = _usuario

    // Atualiza dados básicos
    fun atualizarNome(novoNome: String) {
        _usuario.value = _usuario.value.copy(nome = novoNome)
    }

    fun atualizarCpf(novoCpf: String) {
        _usuario.value = _usuario.value.copy(cpf = novoCpf)
    }

    fun atualizarEmail(novoEmail: String) {
        _usuario.value = _usuario.value.copy(email = novoEmail)
    }

    fun atualizarTelefone(novoTelefone: String) {
        _usuario.value = _usuario.value.copy(telefone = novoTelefone)
    }

    // Atualiza pontos, compras e cupons
    fun adicionarPontos(valor: Int) {
        _usuario.value = _usuario.value.copy(pontos = _usuario.value.pontos + valor)
    }

    fun registrarCompra() {
        _usuario.value = _usuario.value.copy(compras = _usuario.value.compras + 1)
    }

    fun adicionarCupom() {
        _usuario.value = _usuario.value.copy(cupons = _usuario.value.cupons + 1)
    }

    // Define se é cliente VIP
    fun definirVip(status: Boolean) {
        _usuario.value = _usuario.value.copy(clienteVip = status)
    }

    // Logout: limpa dados do usuário
    fun logout() {
        _usuario.value = Usuario()
    }
}
