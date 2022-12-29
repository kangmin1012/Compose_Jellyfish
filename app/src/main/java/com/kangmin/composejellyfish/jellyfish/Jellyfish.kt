package com.kangmin.composejellyfish.jellyfish

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kangmin.composejellyfish.background.blueRadialGradient
import com.kangmin.composejellyfish.ui.theme.ComposeJellyfishTheme

private val solidWhiteColor = SolidColor(Color.White)

@Composable
fun Jellyfish() {
    val vectorPainter = rememberVectorPainter(
        defaultWidth = 530.46f.dp,
        defaultHeight = 563.1f.dp,
        viewportHeight = 530.46f,
        viewportWidth = 563.1f,
        autoMirror = true
    ) { _, _ ->
        Group(
            name = "jellyfish"
        ) {
           Group(name = "tentacles") {
               Path(
                   pathData = JellyFishPaths.tentacle1,
                   fill = solidWhiteColor,
                   fillAlpha = 0.49f
               )

               Path(
                   pathData = JellyFishPaths.tentacle2,
                   fill = solidWhiteColor,
                   fillAlpha = 0.66f
               )

               Path(
                   pathData = JellyFishPaths.tentacle3,
                   fill = solidWhiteColor,
                   fillAlpha = 0.45f
               )

               Path(
                   pathData = JellyFishPaths.tentacle4,
                   fill = solidWhiteColor,
                   fillAlpha = 0.6f
               )
               Path(
                   pathData = JellyFishPaths.tentacle5,
                   fill = solidWhiteColor,
               )
               Path(
                   pathData = JellyFishPaths.tentacle6,
                   fill = solidWhiteColor,
               )
               Path(
                   pathData = JellyFishPaths.tentacle7,
                   fill = solidWhiteColor,
               )
               Path(
                   pathData = JellyFishPaths.tentacle8,
                   fill = solidWhiteColor,
               )
               Path(
                   pathData = JellyFishPaths.tentacle9,
                   fill = solidWhiteColor,
               )
           }
        }
    }

    Image(
        painter = vectorPainter,
        contentDescription = "Jellyfish",
        modifier = Modifier.fillMaxSize().background(blueRadialGradient)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewJellyfish() {
    ComposeJellyfishTheme {
        Jellyfish()
    }
}