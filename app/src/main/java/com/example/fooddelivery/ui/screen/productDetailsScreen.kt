package com.example.fooddelivery.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.ProductDescriptionData
import com.example.fooddelivery.data.ProductPreviewState
import com.example.fooddelivery.ui.screen.component.FlavorSection
import com.example.fooddelivery.data.ProductFlavorState
import com.example.fooddelivery.data.ProductNutritionData
import com.example.fooddelivery.data.ProductNutritionState
import com.example.fooddelivery.ui.screen.component.ProductNutritionSection
import com.example.fooddelivery.ui.screen.component.ProductPreviewSection
import com.example.fooddelivery.data.productFlavorData
import com.example.fooddelivery.ui.screen.component.OrderActionBar
import com.example.fooddelivery.ui.screen.component.ProductDescriptionSection

@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productPreviewState: ProductPreviewState = ProductPreviewState(),
    productFlavors: List<ProductFlavorState> = productFlavorData,
    productNutritionState: ProductNutritionState = ProductNutritionData,
    productDescription: String = ProductDescriptionData
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment =  Alignment.BottomCenter
    ){
        Content(
            productPreviewState =productPreviewState,
            productFlavors = productFlavors,
                productNutritionState = productNutritionState,
                    productDescription = productDescription

        )
        OrderActionBar(
            onAddItemClicked = onAddItemClicked,
            onRemoveItemClicked = onRemoveItemClicked,
            onCheckOutClicked =onChangeOutClicked,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(
                    vertical = 18.dp,
                    horizontal = 8.dp
                )
        )
    }
}

@Composable
fun Content(modifier: Modifier = Modifier,
        productPreviewState: ProductPreviewState ,
            productFlavors: List<ProductFlavorState> ,
            productNutritionState: ProductNutritionState ,
            productDescription: String

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
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        ProductDescriptionSection(
            productDescription = productDescription,
            modifier = Modifier
                .navigationBarsPadding()
                .padding(horizontal = 18.dp)
                .padding(bottom = 24.dp)
        )
    }
}