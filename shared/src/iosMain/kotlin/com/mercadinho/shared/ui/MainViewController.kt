package com.mercadinho.shared.ui

import androidx.compose.ui.window.ComposeUIViewController

/**
 * EntryPoint para iOS.
 * Essa função cria um UIViewController que renderiza o MercadinhoApp,
 * permitindo que o AppDelegate.swift use a mesma UI compartilhada.
 */
fun MainViewController() = ComposeUIViewController {
    MercadinhoApp() // ✅ chama sua UI multiplataforma definida em commonMain
}
