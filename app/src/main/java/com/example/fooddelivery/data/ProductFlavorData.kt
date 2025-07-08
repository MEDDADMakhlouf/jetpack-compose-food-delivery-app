package com.example.fooddelivery.data

import androidx.annotation.DrawableRes
import com.example.fooddelivery.R

data class ProductFlavorState(
    val name : String,
    val price : String,
    @DrawableRes val imgRes: Int
)

val productFlavorData = listOf(
    ProductFlavorState(
        imgRes = R.drawable.im_cheese,
        name = "Chedder",
        price = "$0.79"
    ),
    ProductFlavorState(
        imgRes = R.drawable.im_bacon,
        name = "Bacon",
        price = "$0.52"
    ),
    ProductFlavorState(
        imgRes = R.drawable.im_onion,
        name = "Onion",
        price = "$0.28"
    ),

)