package ge.vazhapp.myapplication.presentation.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ge.vazhapp.myapplication.data.model.ColorsItem
import ge.vazhapp.myapplication.presentation.composable.MainColorCard
import ge.vazhapp.myapplication.presentation.navigation.Screens

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController,
) {
    /**
     * I should use .collectAsStateWithLifecycle instead of .collectAsState()
     * but can't find dependency now.
     */
    val allColors by homeViewModel.allColors.collectAsState()

    HomeScreen(
        allColors = allColors,
        goToDetails = {},
        navController = navController
    )
}

/**
 * Here will be only UI things
 * this Composable don't know anything about viewModel
 * just communicating to parent composable with callbacks.
 */
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    allColors: List<ColorsItem>,
    goToDetails: () -> Unit,
    navController: NavController
) {
    LazyColumn(
        modifier = modifier.wrapContentHeight()
            .clickable {
                       goToDetails()
            },
    ) {
        items(
            allColors.size
        ) { index ->
            val currentColorItem = allColors[index]

            MainColorCard(currentColorItem = currentColorItem, navController = navController)
        }
    }
}