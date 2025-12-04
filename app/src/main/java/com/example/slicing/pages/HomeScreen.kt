package com.example.slicing.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slicing.R
import com.example.slicing.ui.home.CategorySection
import com.example.slicing.ui.home.GreetingSection
import com.example.slicing.ui.home.HomeBackgroundColor
import com.example.slicing.ui.home.HomeTopBar
import com.example.slicing.ui.home.OpenRestaurantHeader
import com.example.slicing.ui.home.RestaurantCard
import com.example.slicing.ui.home.RestaurantUi
import com.example.slicing.ui.home.SearchSection

@Composable
fun HomeScreen() {
    val accentYellow = Color(0xFFFFC857)
    val primaryDark = Color(0xFF25253F)
    val lightGrey = Color(0xFFF5F)


    // list
    val restaurants = remember {
        listOf(
            RestaurantUi(
                name = "Rose Garden Restaurant",
                desc = "Burger · Chicken · Rice · Wings",
                rating = "4.7",
                deliveryFee = "Free",
                eta = "20 min",
                imageRes = R.drawable.res1
            ),
            RestaurantUi(
                name = "Halal Corner",
                desc = "Shawarma · Kebab · Grill",
                rating = "4.5",
                deliveryFee = "Free",
                eta = "18 min",
                imageRes = R.drawable.res2
            ),
            RestaurantUi(
                name = "Street Food Lab",
                desc = "Noodles · Snacks · Drinks",
                rating = "4.3",
                deliveryFee = "IDR 10k",
                eta = "25 min",
                imageRes = R.drawable.res3
            ),
            RestaurantUi(
                name = "Burger Town",
                desc = "Burger · Fries · Soda",
                rating = "4.8",
                deliveryFee = "Free",
                eta = "15 min",
                imageRes = R.drawable.res4
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeBackgroundColor)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(26.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 60.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
            ) {
                item {
                    HomeTopBar()
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    GreetingSection()
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    SearchSection()
                    Spacer(modifier = Modifier.height(24.dp))
                }

                item {
                    CategorySection(
                        accentYellow = accentYellow,
                        primaryDark = primaryDark,
                        lightGrey = lightGrey
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }

                item {
                    OpenRestaurantHeader()
                    Spacer(modifier = Modifier.height(16.dp))
                }

                items(restaurants) { restaurant ->
                    RestaurantCard(restaurant = restaurant)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}
