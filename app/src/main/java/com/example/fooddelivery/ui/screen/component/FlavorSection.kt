package com.example.fooddelivery.ui.screen.component

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.ui.theme.AppTheme

@Composable
fun FlavorSection(
    modifier: Modifier = Modifier
) {
    Column (
        modifier= modifier
    ){
        SectionHeader(title = "Add More Flavor",
            emotion = "\uD83E\uDD29"
            )
    }
}

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String,
    emotion: String
){
    Row (
        modifier= modifier,
        horizantalArrangement = Arrangement.spacedBy(4.dp)
    ){
        Text(
            text = title,
            style = AppTheme.typography.titleLarge,
            color = AppTheme.colors.onBackground
        )
        Text(
            text = emotion,
            style = AppTheme.typography.titleLarge
        )
    }
}