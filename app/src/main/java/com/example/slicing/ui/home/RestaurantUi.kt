package com.example.slicing.ui.home

data class CategoryUi(
    val name: String,
    val iconRes: Int
)

data class RestaurantUi(
    val name: String,
    val desc: String,
    val rating: String,
    val deliveryFee: String,
    val eta: String,
    val imageRes: Int
)