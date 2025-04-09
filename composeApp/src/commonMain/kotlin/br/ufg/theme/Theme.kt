//composeApp/src/commonMain/kotlin/br.ufg/theme/Theme.kt
package br.ufg.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Cores da UFG (aproximadas)
private val UFGBlue = Color(0xFF003366)
private val UFGGreen = Color(0xFF007045)

// Esquema de cores claro
private val LightColors = lightColorScheme(
    primary = UFGBlue,
    secondary = UFGGreen,
    primaryContainer = Color(0xFFD1E4FF),
    secondaryContainer = Color(0xFFB6EACD),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onPrimaryContainer = UFGBlue,
    onSecondaryContainer = UFGGreen,
    surface = Color(0xFFF8FDFF),
    background = Color(0xFFF8FDFF)
)

// Esquema de cores escuro
private val DarkColors = darkColorScheme(
    primary = Color(0xFF90CAFF),
    secondary = Color(0xFF94DAB9),
    primaryContainer = Color(0xFF00497E),
    secondaryContainer = Color(0xFF005233),
    onPrimary = Color(0xFF003258),
    onSecondary = Color(0xFF003822),
    onPrimaryContainer = Color(0xFFD1E4FF),
    onSecondaryContainer = Color(0xFFB6EACD),
    surface = Color(0xFF001F2A),
    background = Color(0xFF001F2A)
)

@Composable
fun FCTUFGTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}