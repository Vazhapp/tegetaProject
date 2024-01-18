package ge.vazhapp.myapplication.presentation.ui.screens.details

import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import ge.vazhapp.myapplication.presentation.navigation.Screens

@Composable
fun DetailsScreen(
    detailsViewModel: DetailsViewModel,
    imageUrl: String,
    imageTitle: String,
    imageUsername: String,
) {

    DetailsScreen(url = imageUrl, title = imageTitle, username = imageUsername)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    url: String,
    title: String,
    username: String,
) {

    val rememberImagePainter =
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url).build(),
        )

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                },
            painter = rememberImagePainter,
            contentDescription = "Empty",
            contentScale = ContentScale.Crop
        )

        Column {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = username,
                fontSize = 14.sp,
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}