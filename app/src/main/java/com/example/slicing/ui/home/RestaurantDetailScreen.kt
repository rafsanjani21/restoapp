package com.example.slicing.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.slicing.R

data class MenuItemUi(
    val name: String,
    val desc: String,
    val price: String,
    val imageRes: Int
)

@Composable
fun RestaurantDetailScreen(
    navController: NavController,
    restaurant: RestaurantUi
) {
    val primaryDark = HomePrimaryDark
    val accentYellow = HomeAccentYellow
    val lightGrey = HomeLightGrey

    val menuItems = remember {
        listOf(
            MenuItemUi("Burger Ferguson", restaurant.name, "$40", R.drawable.burger),
            MenuItemUi("Rockin' Burgers", "Cafecachino", "$40", R.drawable.burger),
            MenuItemUi("Double Cheese", "House Special", "$45", R.drawable.burger),
            MenuItemUi("Big Combo", "Spicy Restaurant", "$55", R.drawable.burger),
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F3F5))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 60.dp,
                    start = 20.dp,
                    end = 20.dp
                )
        ) {
            // Top bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = lightGrey
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }

                Text(
                    text = "Restaurant View",
                    fontSize = 14.sp,
                    color = primaryDark
                )

                Surface(
                    shape = CircleShape,
                    color = lightGrey
                ) {
                    IconButton(onClick = { /* TODO more */ }) {
                        Icon(Icons.Default.AddCircle, contentDescription = "More")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Foto restoran besar (dinamis)
            Image(
                painter = painterResource(id = restaurant.imageRes),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(24.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nama + deskripsi
            Text(
                text = restaurant.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = primaryDark
            )
            Text(
                text = restaurant.desc,
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Rating + free + time
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = accentYellow,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(restaurant.rating, fontSize = 13.sp, color = primaryDark)
                }

                Text(restaurant.deliveryFee, fontSize = 13.sp, color = primaryDark)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        tint = accentYellow,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(restaurant.eta, fontSize = 13.sp, color = primaryDark)
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Burger (10)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = primaryDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ---- MENU DALAM 2 KOLOM (LAZYCOLUMN) ----
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(menuItems.chunked(2)) { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // kiri
                        MenuCard(
                            item = rowItems[0],
                            modifier = Modifier.weight(1f)
                        )

                        // kanan (kalau ada)
                        if (rowItems.size > 1) {
                            MenuCard(
                                item = rowItems[1],
                                modifier = Modifier.weight(1f)
                            )
                        } else {
                            Spacer(
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MenuCard(
    item: MenuItemUi,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier.height(80.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.name,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = HomePrimaryDark
            )
            Text(
                text = item.desc,
                fontSize = 11.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.price,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = HomePrimaryDark
                )

                Surface(
                    shape = CircleShape,
                    color = HomeAccentYellow
                ) {
                    Text(
                        text = "+",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RestaurantDetailPreview() {
    val nav = rememberNavController()
    val dummy = RestaurantUi(
        imageRes = R.drawable.res1,
        name = "Spicy Restaurant",
        desc = "Burger · Chicken · Rice · Wings",
        rating = "4.7",
        deliveryFee = "Free",
        eta = "20 min"
    )
    RestaurantDetailScreen(navController = nav, restaurant = dummy)
}
