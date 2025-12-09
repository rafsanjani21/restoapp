package com.example.slicing.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.slicing.R

data class ProfileMenuItem(
    val iconTint: Color,
    val iconBackground: Color,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val title: String,
    val onClick: (() -> Unit)? = null
)

@Composable
fun ProfileScreen(
    navController: NavController? = null
) {
    val background = Color(0xFFF3F3F5)
    val cardCorner = 24.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 60.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
        ) {

            // TOP BAR
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Surface(
                        modifier = Modifier.size(36.dp),
                        shape = CircleShape,
                        color = Color(0xFFFFFFFF)
                    ) {
                        IconButton(onClick = { navController?.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color(0xFF9093A6)
                            )
                        }
                    }

                    Text(
                        text = "Profile",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF303345)
                    )

                    Surface(
                        modifier = Modifier.size(36.dp),
                        shape = CircleShape,
                        color = Color(0xFFEDEFF4)
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More",
                                tint = Color(0xFF303345)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

            // HEADER PROFILE
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(cardCorner),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Profile photo",
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "San",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF303345)
                            )
                            Text(
                                text = "I love etanol",
                                fontSize = 13.sp,
                                color = Color(0xFF9FA4B4)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }

            // CARD 1
            item {
                ProfileMenuCard(
                    items = listOf(
                        ProfileMenuItem(
                            iconTint = Color(0xFFFF8A5B),
                            iconBackground = Color(0xFFFFF3EC),
                            icon = Icons.Default.Person,
                            title = "Personal Info",
                            onClick = {
                                navController?.navigate("editProfile")
                            }
                        ),
                        ProfileMenuItem(
                            iconTint = Color(0xFF5B8CFF),
                            iconBackground = Color(0xFFEAF1FF),
                            icon = Icons.Default.Place,
                            title = "Addresses"
                        )
                    ),
                    cornerRadius = cardCorner
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // CARD 2
            item {
                ProfileMenuCard(
                    items = listOf(
                        ProfileMenuItem(
                            iconTint = Color(0xFF5B8CFF),
                            iconBackground = Color(0xFFEAF1FF),
                            icon = Icons.Default.ShoppingCart,
                            title = "Cart"
                        ),
                        ProfileMenuItem(
                            iconTint = Color(0xFFFF6B81),
                            iconBackground = Color(0xFFFFEDF1),
                            icon = Icons.Default.Star,
                            title = "Favourite"
                        ),
                        ProfileMenuItem(
                            iconTint = Color(0xFFFFC857),
                            iconBackground = Color(0xFFFFF5DA),
                            icon = Icons.Default.Notifications,
                            title = "Notifications"
                        ),
                        ProfileMenuItem(
                            iconTint = Color(0xFF34C759),
                            iconBackground = Color(0xFFE7F9EE),
                            icon = Icons.Default.Warning,
                            title = "Payment Method"
                        )
                    ),
                    cornerRadius = cardCorner
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // CARD 3
            item {
                ProfileMenuCard(
                    items = listOf(
                        ProfileMenuItem(
                            iconTint = Color(0xFFFF6B6B),
                            iconBackground = Color(0xFFFFE9E9),
                            icon = Icons.Default.Call,
                            title = "FAQs"
                        ),
                        ProfileMenuItem(
                            iconTint = Color(0xFF34C759),
                            iconBackground = Color(0xFFE7F9EE),
                            icon = Icons.Default.ThumbUp,
                            title = "User Reviews"
                        ),
                        ProfileMenuItem(
                            iconTint = Color(0xFF5B8CFF),
                            iconBackground = Color(0xFFEAF1FF),
                            icon = Icons.Default.Settings,
                            title = "Settings"
                        )
                    ),
                    cornerRadius = cardCorner
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // CARD LOGOUT
            item {
                ProfileMenuCard(
                    items = listOf(
                        ProfileMenuItem(
                            iconTint = Color(0xFFFF6B6B),
                            iconBackground = Color(0xFFFFE9E9),
                            icon = Icons.Default.Clear,
                            title = "Log Out"
                        )
                    ),
                    cornerRadius = cardCorner
                )
            }
        }
    }
}

@Composable
private fun ProfileMenuCard(
    items: List<ProfileMenuItem>,
    cornerRadius: Dp
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(cornerRadius),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column {
            items.forEachIndexed { index, item ->
                ProfileMenuRow(item = item)

                if (index < items.lastIndex) {
                    Divider(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        color = Color(0xFFE6E8F0),
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileMenuRow(
    item: ProfileMenuItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{ item.onClick?.invoke() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Surface(
                modifier = Modifier.size(32.dp),
                shape = CircleShape,
                color = item.iconBackground
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = item.iconTint,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = item.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF303345)
            )
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Go",
            tint = Color(0xFFBEC3D2)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        ProfileScreen(navController = navController)
    }
}
