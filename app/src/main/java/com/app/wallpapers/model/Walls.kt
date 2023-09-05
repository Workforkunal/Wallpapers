package com.app.wallpapers.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Walls(
    @StringRes val name: Int,
    val availableWallpapers: Int,
    @DrawableRes val imageRes: Int
)
