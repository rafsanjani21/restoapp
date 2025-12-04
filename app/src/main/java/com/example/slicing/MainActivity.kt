package com.example.slicing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.slicing.pages.HomeScreen
import com.example.slicing.ui.home.SplashScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.slicing.ui.home.RestaurantDetailScreen
import com.example.slicing.ui.home.RestaurantUi



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Initialize the NavController here
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "splash"
            ) {
                composable("splash") { SplashScreen(navController) }

                composable("home") { HomeScreen(navController) }

                composable(
                    route = "restaurantDetail/{imageRes}/{name}/{desc}/{rating}/{deliveryFee}/{eta}",
                    arguments = listOf(
                        navArgument("imageRes") { type = NavType.IntType },
                        navArgument("name") { type = NavType.StringType },
                        navArgument("desc") { type = NavType.StringType },
                        navArgument("rating") { type = NavType.StringType },
                        navArgument("deliveryFee") { type = NavType.StringType },
                        navArgument("eta") { type = NavType.StringType },
                    )
                ) { backStackEntry ->
                    val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: R.drawable.res1
                    val name = backStackEntry.arguments?.getString("name") ?: ""
                    val desc = backStackEntry.arguments?.getString("desc") ?: ""
                    val rating = backStackEntry.arguments?.getString("rating") ?: ""
                    val deliveryFee = backStackEntry.arguments?.getString("deliveryFee") ?: ""
                    val eta = backStackEntry.arguments?.getString("eta") ?: ""

                    val restaurant = RestaurantUi(
                        imageRes = imageRes,
                        name = name,
                        desc = desc,
                        rating = rating,
                        deliveryFee = deliveryFee,
                        eta = eta
                    )

                    RestaurantDetailScreen(
                        navController = navController,
                        restaurant = restaurant
                    )
                }
            }

        }
    }
}

