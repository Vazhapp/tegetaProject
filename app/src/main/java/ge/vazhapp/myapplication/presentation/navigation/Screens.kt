package ge.vazhapp.myapplication.presentation.navigation

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

const val IMAGE_URL = "imageUrl"
const val TITLE = "imageTitle"
const val USERNAME = "imageUsername"

sealed class Screens(val route: String) {
    object HomeScreen : Screens(route = "home_screen")

    object DetailsScreen : Screens(route = "details_screen/{$IMAGE_URL}/{$TITLE}/{$USERNAME}") {
        fun passPaintDetails(imageUrl: String, imageTitle: String, imageUsername: String): String {
            val encodedUrl = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())

            return "details_screen/$encodedUrl/$imageTitle/$imageUsername"
        }
    }
}