package com.kangmin.composejellyfish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kangmin.composejellyfish.jellyfish.Jellyfish
import com.kangmin.composejellyfish.ui.theme.ComposeJellyfishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeJellyfishTheme {
                Jellyfish()
            }
        }
    }
}