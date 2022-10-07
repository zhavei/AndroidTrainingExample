package com.syafei.belajarfundamentalaplikasiandroidrecylerview.animal.data

import androidx.annotation.DrawableRes

data class Hewan(
    @DrawableRes
    val images: Int = 0,
    val names: String = "",
    val age: Int = 0,
    val food: String = ""

)
