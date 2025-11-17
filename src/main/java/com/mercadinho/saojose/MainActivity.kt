package com.mercadinho.saojose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mercadinho.shared.ui.MercadinhoApp // ✅ import do módulo shared
import com.mercadinho.saojose.ui.theme.MercadinhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadinhoTheme {
                MercadinhoApp() // ✅ chama o app compartilhado do módulo shared
            }
        }
    }
}
