package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.fooddelivery.data.OrderState
import com.example.fooddelivery.ui.screen.ProductDetailsScreen
import com.example.fooddelivery.ui.theme.AppTheme

private const val PRODUCT_PRICE_PER_UNIT = 5.25
private const val PRODUCT_CURRENCY = "$"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide system bars using backward-compatible API
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.isAppearanceLightNavigationBars = false
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            controller.hide(WindowInsetsCompat.Type.systemBars())
        }

        enableEdgeToEdge()

        setContent {
            AppTheme {
                var amount by remember { mutableIntStateOf(5) }
                val totalPrice by remember {
                    derivedStateOf { amount * PRODUCT_PRICE_PER_UNIT }
                }

                ProductDetailsScreen(
                    onCheckOutClicked = {},
                    onRemoveItemClicked = { if (amount > 0) amount-- },
                    onAddItemClicked = { amount++ },
                    orderState = OrderState(
                        amount = amount,
                        totalPrice = "$PRODUCT_CURRENCY${totalPrice}"
                    )
                )
            }
        }
    }
}
