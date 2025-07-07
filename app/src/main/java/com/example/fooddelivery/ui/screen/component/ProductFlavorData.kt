package com.example.fooddelivery.ui.screen.component

import androidx.annotation.DrawableRes

data class ProductFlavorState(
    val name : String,
    val price : Stringm,
    @DrawableRes val imgRes: Int
)

val productFlavorData = listOf(
    ProductFlavorState(
        imgRes = R.drawable.im_cheese,
        name = "Chedder",
        price = "$0.79"
    ),
    ProductFlavorState(
        imgRes = R.drawable.im_cheese,
        name = "Bacon",
        price = "$0.52"
    ),
    ProductFlavorState(
        imgRes = R.drawable.im_cheese,
        name = "Onion",
        price = "$0.28"
    ),

)