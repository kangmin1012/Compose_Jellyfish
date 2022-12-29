package com.kangmin.composejellyfish.jellyfish

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kangmin.composejellyfish.background.blueRadialGradient
import com.kangmin.composejellyfish.ui.theme.ComposeJellyfishTheme
import com.kangmin.composejellyfish.ui.theme.Gray
import com.kangmin.composejellyfish.ui.theme.Gray300
import com.kangmin.composejellyfish.ui.theme.White300
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private val solidWhiteColor = SolidColor(Color.White)
private val solidWhite300Color = SolidColor(White300)
private val solidGrayColor = SolidColor(Gray)
private val solidGray300Color = SolidColor(Gray300)

@Composable
fun Jellyfish() {
    val rememberCoroutineScope = rememberCoroutineScope()
    val blinkAlphaAnimation = remember {
        Animatable(1f)
    }
    val blinkScaleAnimation = remember {
        Animatable(1f)
    }

    suspend fun startBlinkAnimation() {
        val tweenSpec = tween<Float>(durationMillis = 150, easing = LinearEasing)
        coroutineScope {
            launch {
                blinkAlphaAnimation.animateTo(targetValue = 0f, animationSpec = tweenSpec)
                blinkAlphaAnimation.animateTo(targetValue = 1f, animationSpec = tweenSpec)
            }
            launch {
                blinkScaleAnimation.animateTo(targetValue = 0.3f, animationSpec = tweenSpec)
                blinkScaleAnimation.animateTo(targetValue = 1f, animationSpec = tweenSpec)
            }
        }
    }

    /** 해파리 vector 이미지 */
    val vectorPainter = rememberVectorPainter(
        defaultWidth = 530.46f.dp,
        defaultHeight = 563.1f.dp,
        viewportHeight = 530.46f,
        viewportWidth = 563.1f,
        autoMirror = true
    ) { viewportWiddth, viewportHeight ->

        val duration = 3000 // 애니메이션 시간
        val transition = rememberInfiniteTransition() // 무한 애니메이션 만들기
        val translationY by transition.animateFloat(
            initialValue = 0f,
            targetValue = -30f,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = duration, easing = EaseInOut),
                repeatMode = RepeatMode.Reverse
            )
        )

        // 해파리의 몸체 VectorDrawable
        Group(
            name = "jellyfish",
            translationY = translationY
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
                Group(
                    name = "eye",
                    scaleY = blinkScaleAnimation.value,
                    pivotY = 233f
                ) {
                    Path(
                        pathData = JellyFishPaths.leftEye,
                        fill = solidGrayColor,
                        fillAlpha = blinkAlphaAnimation.value
                    )
                    Path(
                        pathData = JellyFishPaths.rightEye,
                        fill = solidGrayColor,
                        fillAlpha = blinkAlphaAnimation.value
                    )
                }
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
            .pointerInput(Unit) {
                detectTapGestures {
                    rememberCoroutineScope.launch {
                        startBlinkAnimation()
                    }
                }
            }
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