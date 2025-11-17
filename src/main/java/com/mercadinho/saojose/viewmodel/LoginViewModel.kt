package com.mercadinho.saojose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class LoginViewModel : ViewModel() {

    // Estados observáveis
    private val _cpf = mutableStateOf("")
    val cpf: State<String> get() = _cpf

    private val _senha = mutableStateOf("")
    val senha: State<String> get() = _senha

    private val _erro = mutableStateOf<String?>(null)
    val erro: State<String?> get() = _erro

    private val _autenticado = mutableStateOf(false)
    val autenticado: State<Boolean> get() = _autenticado

    private val _carregando = mutableStateOf(false)
    val carregando: State<Boolean> get() = _carregando

    // Atualiza campos
    fun atualizarCpf(novoCpf: String) {
        _cpf.value = novoCpf
    }

    fun atualizarSenha(novaSenha: String) {
        _senha.value = novaSenha
    }

    // Simula autenticação
    fun autenticar() {
        _carregando.value = true
        _erro.value = null

        // Simulação simples (substitua por lógica real depois)
        if (_cpf.value == "161.231.756-10" && _senha.value == "leozin3345") {
            _autenticado.value = true
        } else {
            _erro.value = "CPF ou senha inválidos"
        }

        _carregando.value = false
    }

    fun limparEstado() {
        _erro.value = null
        _autenticado.value = false
        _carregando.value = false
    }
}
