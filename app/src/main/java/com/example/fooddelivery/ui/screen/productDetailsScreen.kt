package com.example.fooddelivery.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.ProductPreviewState
import com.example.fooddelivery.ui.screen.component.FlavorSection
import com.example.fooddelivery.data.ProductFlavorState
import com.example.fooddelivery.data.ProductNutritionData
import com.example.fooddelivery.data.ProductNutritionState
import com.example.fooddelivery.ui.screen.component.ProductNutritionSection
import com.example.fooddelivery.ui.screen.component.ProductPreviewSection
import com.example.fooddelivery.data.productFlavorData

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productFlavorState: List<ProductFlavorState> = productFlavorData,
    productNutritionState: ProductNutritionState = ProductNutritionData
) {
    val scrollableState = rememberScrollState()
    Column(
        modifier = modifier.verticalScroll(scrollableState)
    ) {
        ProductPreviewSection(
            state = productPreviewState
        )
        Spacer(modifier = Modifier.height(6.dp))
        FlavorSection(
            modifier = Modifier.padding(18.dp),
            data = productFlavorState
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        ProductNutritionSection(
            modifier = Modifier.padding(horizontal = 18.dp),
            state = productNutritionState
        )
    }
}