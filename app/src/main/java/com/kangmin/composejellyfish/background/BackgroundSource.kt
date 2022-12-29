package com.kangmin.composejellyfish.background

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import com.kangmin.composejellyfish.ui.theme.DeepBlue
import com.kangmin.composejellyfish.ui.theme.Sky

val blueRadialGradient = object : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        val biggerDimension = maxOf(size.height, size.width)
        return RadialGradientShader(
            center = size.center,
            radius = biggerDimension / 2f,
            colors = listOf(Sky, DeepBlue),
            colorStops = listOf(0f, 0.95f),
        )
    }
}