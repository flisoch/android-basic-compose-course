package com.example.gridlist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResourceId: Int,
    @StringRes val coursesCountResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
