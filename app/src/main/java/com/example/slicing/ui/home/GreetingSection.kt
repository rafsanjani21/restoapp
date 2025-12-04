package com.example.slicing.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun GreetingSection() {
    Column {
        Text(
            text = "Hey Bahleel,",
            fontSize = 16.sp,
            color = HomePrimaryDark
        )
        Text(
            text = "Good Afternoon!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = HomePrimaryDark
        )
    }
}