package com.mercadinho.saojose.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.mercadinho.saojose.model.Produto

// Representa um item no carrinho com produto e quantidade
data class ItemCarrinho(
    val produto: Produto,
    var quantidade: Int = 1
)

class CarrinhoViewModel : ViewModel() {

    // Lista reativa de itens no carrinho
    private val _itensCarrinho = mutableStateListOf<ItemCarrinho>()
    val itensCarrinho: SnapshotStateList<ItemCarrinho> get() = _itensCarrinho

    // Contador total de unidades no carrinho (usado para badge)
    var contador = mutableStateOf(0)
        private set

    // Atualiza o contador com a soma das quantidades
    private fun atualizarContador() {
        contador.value = _itensCarrinho.sumOf { it.quantidade }
    }

    // Adiciona um produto ao carrinho ou incrementa a quantidade
    fun adicionarProduto(produto: Produto) {
        val itemExistente = _itensCarrinho.find { it.produto.nome == produto.nome }
        if (itemExistente != null) {
            val index = _itensCarrinho.indexOf(itemExistente)
            _itensCarrinho[index] = itemExistente.copy(quantidade = itemExistente.quantidade + 1)
        } else {
            _itensCarrinho.add(ItemCarrinho(produto))
        }
        atualizarContador()
    }

    // Remove uma unidade do produto ou exclui do carrinho se quantidade for 1
    fun removerProduto(produto: Produto) {
        val itemExistente = _itensCarrinho.find { it.produto.nome == produto.nome }
        if (itemExistente != null) {
            val index = _itensCarrinho.indexOf(itemExistente)
            if (itemExistente.quantidade > 1) {
                _itensCarrinho[index] = itemExistente.copy(quantidade = itemExistente.quantidade - 1)
            } else {
                _itensCarrinho.removeAt(index)
            }
        }
        atualizarContador()
    }

    // Remove todos os itens do carrinho
    fun limparCarrinho() {
        _itensCarrinho.clear()
        atualizarContador()
    }

    // Finaliza a compra (exemplo: limpar carrinho)
    fun finalizarCompra() {
        // Aqui você pode integrar com backend ou exibir confirmação
        _itensCarrinho.clear()
        atualizarContador()
    }
}
