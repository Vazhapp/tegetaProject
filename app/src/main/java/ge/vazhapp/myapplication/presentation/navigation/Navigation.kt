package ge.vazhapp.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ge.vazhapp.myapplication.presentation.ui.screens.details.DetailsScreen
import ge.vazhapp.myapplication.presentation.ui.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(homeViewModel = hiltViewModel(), navController = navController)
        }
        composable(
            route = Screens.DetailsScreen.route,
            arguments = listOf(
                navArgument(IMAGE_URL) {
                    type = NavType.StringType
                },
                navArgument(TITLE) {
                    type = NavType.StringType
                },
                navArgument(USERNAME) {
                    type = NavType.StringType
                }
            )
        ) {
            DetailsScreen(
                hiltViewModel(),
                imageUrl = it.arguments?.getString(IMAGE_URL).orEmpty(),
                imageTitle = it.arguments?.getString(TITLE).orEmpty(),
                imageUsername = it.arguments?.getString(USERNAME).orEmpty()
            )
        }

    }
}