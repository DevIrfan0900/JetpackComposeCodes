package com.compose.recyclerview

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.recyclerview.ui.theme.RecyclerviewTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecyclerviewTheme {
                val navController = rememberNavController()
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        Surface(
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            CategoryListScreen(navController)

                            AppNavHost(navController)

                        }
                    }
                )
            }
        }

    }

    @Composable
    fun AppNavHost(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = "categoryList"
        ) {
            composable("categoryList") {
                CategoryListScreen(navController)
            }

            composable(
                route = "detail/{imgRes}/{title}/{subtitle}",
                arguments = listOf(
                    androidx.navigation.navArgument("imgRes") {
                        type = androidx.navigation.NavType.IntType
                    },
                    androidx.navigation.navArgument("title") {
                        type = androidx.navigation.NavType.StringType
                    },
                    androidx.navigation.navArgument("subtitle") {
                        type = androidx.navigation.NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val imgRes = backStackEntry.arguments?.getInt("imgRes") ?: 0
                val title = backStackEntry.arguments?.getString("title") ?: ""
                val subtitle = backStackEntry.arguments?.getString("subtitle") ?: ""
                DetailScreen(imgRes = imgRes, title = title, subtitle = subtitle, navController)
            }
        }
    }

}