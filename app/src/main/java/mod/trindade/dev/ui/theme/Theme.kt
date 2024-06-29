package mod.trindade.dev.ui.theme

import android.app.*
import android.os.*

import androidx.compose.foundation.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.*
import androidx.core.view.*

import com.sketchware.remod.R

@Composable
fun TrindadeWareTheme (
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colors = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                 dynamicDarkColorScheme(context) 
            } else {
                 dynamicLightColorScheme(context)
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    MaterialTheme(
        colorScheme = colors,
        content = content,
        typography = TrindadeWareTypography
    )
}

val DarkColorScheme  = darkColorScheme(
    primary = DarkColors.primary,
    onPrimary = DarkColors.onPrimary,
    primaryContainer = DarkColors.primaryContainer,
    onPrimaryContainer = DarkColors.onPrimaryContainer,secondary = DarkColors.secondary,
    onSecondary = DarkColors.onSecondary,
    secondaryContainer = DarkColors.secondaryContainer,
    onSecondaryContainer = DarkColors.onSecondaryContainer,
    tertiary = DarkColors.tertiary,
    onTertiary = DarkColors.onTertiary,
    tertiaryContainer = DarkColors.tertiaryContainer,onTertiaryContainer = DarkColors.onTertiaryContainer,
    error = DarkColors.error,
    errorContainer = DarkColors.errorContainer,
    onError = DarkColors.onError,
    onErrorContainer = DarkColors.onErrorContainer,
    background = DarkColors.background,
    onBackground = DarkColors.onBackground,
    surface = DarkColors.surface,
    onSurface = DarkColors.onSurface,
    surfaceVariant = DarkColors.surfaceVariant,
    onSurfaceVariant = DarkColors.onSurfaceVariant,
    outline = DarkColors.outline,
    inverseOnSurface = DarkColors.inverseOnSurface,
    inverseSurface = DarkColors.inverseSurface,
    inversePrimary = DarkColors.inversePrimary,
    surfaceTint = DarkColors.surfaceTint,
    outlineVariant = DarkColors.outlineVariant,
    scrim = DarkColors.scrim
)

val LightColorScheme = lightColorScheme(
    primary = LightColors.primary,
    onPrimary = LightColors.onPrimary,
    primaryContainer = LightColors.primaryContainer,
    onPrimaryContainer = LightColors.onPrimaryContainer,
    secondary = LightColors.secondary,
    onSecondary = LightColors.onSecondary,
    secondaryContainer = LightColors.secondaryContainer,
    onSecondaryContainer = LightColors.onSecondaryContainer,
    tertiary = LightColors.tertiary,
    onTertiary = LightColors.onTertiary,
    tertiaryContainer = LightColors.tertiaryContainer,
    onTertiaryContainer = LightColors.onTertiaryContainer,
    error = LightColors.error,
    errorContainer = LightColors.errorContainer,
    onError = LightColors.onError,
    onErrorContainer = LightColors.onErrorContainer,
    background = LightColors.background,
    onBackground = LightColors.onBackground,
    surface = LightColors.surface,
    onSurface = LightColors.onSurface,
    surfaceVariant = LightColors.surfaceVariant,
    onSurfaceVariant = LightColors.onSurfaceVariant,
    outline = LightColors.outline,
    inverseOnSurface = LightColors.inverseOnSurface,
    inverseSurface = LightColors.inverseSurface,
    inversePrimary = LightColors.inversePrimary,
    surfaceTint = LightColors.surfaceTint,
    outlineVariant = LightColors.outlineVariant,
    scrim = LightColors.scrim
)