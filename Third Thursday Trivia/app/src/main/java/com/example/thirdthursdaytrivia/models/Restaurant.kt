package com.example.thirdthursdaytrivia.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Restaurant(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
    @StringRes val rating: Int,
    @StringRes val cost: Int
    )