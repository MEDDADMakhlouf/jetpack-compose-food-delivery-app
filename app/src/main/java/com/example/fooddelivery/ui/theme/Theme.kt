package com.example.fooddelivery.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides extendedColors,
        LocalAppTypoGraphy provides extendedTypography
    ) {
        MaterialTheme(
            // You can add colorScheme or typography if you want to customize Material3 theme further
            content = content
        )
    }
}

object AppTheme {
    val colors: AppColors
        @Composable get() = LocalAppColors.current

    val typography: AppTypography
        @Composable get() = LocalAppTypoGraphy.current
}
