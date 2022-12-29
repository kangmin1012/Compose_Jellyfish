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
import com.kangmin.composejellyfish.ui.theme.Gray
import com.kangmin.composejellyfish.ui.theme.Gray300
import com.kangmin.composejellyfish.ui.theme.White300

private val solidWhiteColor = SolidColor(Color.White)
private val solidWhite300Color = SolidColor(White300)
private val solidGrayColor = SolidColor(Gray)
private val solidGray300Color = SolidColor(Gray300)

@Composable
fun Jellyfish() {
    val vectorPainter = rememberVectorPainter(
        defaultWidth = 530.46f.dp,
        defaultHeight = 563.1f.dp,
        viewportHeight = 530.46f,
        viewportWidth = 563.1f,
        autoMirror = true
    ) { _, _ ->

        // 해파리의 몸체 VectorDrawable
        Group(
            name = "jellyfish"
        ) {
            // 해파리 촉수 Vector Group
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
            // 해파리 몸체 Vector Group
            Group(name = "body") {
                Path(
                    pathData = JellyFishPaths.face,
                    fill = solidWhiteColor
                )
                Path(
                    pathData = JellyFishPaths.outerJelly,
                    fill = solidWhiteColor,
                    fillAlpha = 0.5f
                )
            }
            // 해파리 얼굴의 주근깨 Vector Group
            Group(name = "freckles") {
                Path(
                    pathData = JellyFishPaths.freckle1,
                    fill = solidWhite300Color
                )
                Path(
                    pathData = JellyFishPaths.freckle2,
                    fill = solidWhite300Color
                )
                Path(
                    pathData = JellyFishPaths.freckle3,
                    fill = solidWhite300Color
                )
                Path(
                    pathData = JellyFishPaths.freckle4,
                    fill = solidWhite300Color
                )
            }
            // 해파리 얼굴 Vector Group
            Group(name = "face") {
                Path(
                    pathData = JellyFishPaths.leftEye,
                    fill = solidGrayColor
                )
                Path(
                    pathData = JellyFishPaths.rightEye,
                    fill = solidGrayColor
                )
                Path(
                    pathData = JellyFishPaths.mouth,
                    fill = solidGray300Color
                )
            }
        }

        // 해파리 주변 거품 VectorDrawable
        Group(
            name = "bubble"
        ) {
            Path(
                pathData = JellyFishPaths.bubble1,
                fill = solidWhiteColor,
                fillAlpha = 0.67f
            )

            Path(
                pathData = JellyFishPaths.bubble2,
                fill = solidWhiteColor,
                fillAlpha = 0.75f
            )

            Path(
                pathData = JellyFishPaths.bubble3,
                fill = solidWhiteColor,
                fillAlpha = 0.89f
            )

            Path(
                pathData = JellyFishPaths.bubble4,
                fill = solidWhiteColor,
                fillAlpha = 0.77f
            )

            Path(
                pathData = JellyFishPaths.bubble5,
                fill = solidWhiteColor,
                fillAlpha = 0.77f
            )
        }
    }

    Image(
        painter = vectorPainter,
        contentDescription = "Jellyfish",
        modifier = Modifier
            .fillMaxSize()
            .background(blueRadialGradient)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewJellyfish() {
    ComposeJellyfishTheme {
        Jellyfish()
    }
}