package com.example.fooddelivery.ui.screen.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.data.OrderState
import com.example.fooddelivery.ui.theme.AppTheme

@Composable
fun OrderActionBar(
    modifier: Modifier = Modifier,
    state: OrderState,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked : () -> Unit,
    onCheckOutClicked : () -> Unit

) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color = AppTheme.colors.surface,
        contentColor = AppTheme.colors.onSurface,
        shadowElevation = 16.dp
    ) {
        Row (
            modifier = Modifier
                .padding(8.dp)
                .height(76.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Row (
                modifier = Modifier
                    .padding(8.dp)
                    .height(76.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Selector(
                    amount = state.amount,
                    onAddItemClicked = onAddItemClicked,
                    onRemoveItemClicked = onRemoveItemClicked,
                    modifier = Modifier.weight(weight = 1f)
                )
                Cart(
                    totalPrice = state.totalPrice,
                    onClicked = onAddItemClicked,
                    modifier = Modifier.weight(weight = 1f)
                )
            }
        }
    }
}

@Composable
private fun Selector(
    modifier: Modifier = Modifier,
    amount : Int,
    onAddItemClicked: () -> Unit,
    onRemoveItemClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = AppTheme.colors.secondarySurface,
                shape = RoundedCornerShape(20.dp)
            ),
        contentAlignment = Alignment.Center
    ){
Row (
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(16.dp)
){
     SelectorButton(
         iconRes = R.drawable.ic_minus,
         contentColor = AppTheme.colors.onActionSurface,
         containerColor = AppTheme.colors.actionSurface,
         onClicked = onRemoveItemClicked
     )
    Text(
        text = amount.toString(),
        color = AppTheme.colors.onSurface,
        style = AppTheme.typography.titleLarge
    )
    SelectorButton(
        iconRes = R.drawable.ic_plus,
        contentColor = AppTheme.colors.secondarySurface,
        containerColor = AppTheme.colors.onSecondarySurface,
        onClicked = onAddItemClicked
    )
}
    }
}

@Composable
private fun SelectorButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int,
    contentColor: Color,
    containerColor: Color,
    onClicked: () -> Unit
) {
    Surface(
        modifier = Modifier.size(24.dp),
        shape = CircleShape,
        color = containerColor,
        contentColor = contentColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onClicked),
                    contentAlignment = Alignment.Center
        ){
            Icon (painter = painterResource(id = iconRes),
                contentDescription = null ,
                modifier = Modifier.size(7.dp)
            )
        }
    }
}

@Composable
private fun Cart(
    modifier: Modifier = Modifier,
    totalPrice : String,
    onClicked : () -> Unit
){
    Surface(
        modifier = modifier.clickable(onClick = onClicked),
        color = AppTheme.colors.secondarySurface,
        contentColor = AppTheme.colors.onSecondarySurface,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Add to Cart",
                    style = AppTheme.typography.titleSmall
                )
                Text(
                    text = totalPrice,
                    style = AppTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}