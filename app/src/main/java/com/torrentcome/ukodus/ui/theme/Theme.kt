package com.torrentcome.ukodus.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val Blue400 = Color(0xFF7E8ACD)
val Blue200 = Color(0xFFA4B0D9)
val Jaguar = Color(0xFF202030)
val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

private val lightThemeColors = lightColors(
    primary = Blue400,
    primaryVariant = Blue400,
    secondary = Blue400,
    secondaryVariant = Blue400,
    onPrimary = Black
)

private val darkThemeColors = darkColors(
    primary = Blue200,
    primaryVariant = Blue200,
    secondary = Blue200,
    background = Jaguar,
    surface = Jaguar
)


val shapes = Shapes(
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(12.dp)
)

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) darkThemeColors else lightThemeColors,
        content = content,
        shapes = shapes
    )
}