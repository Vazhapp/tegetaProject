package ge.vazhapp.myapplication.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import ge.vazhapp.myapplication.data.model.Colors
import ge.vazhapp.myapplication.data.model.ColorsItem
import ge.vazhapp.myapplication.presentation.navigation.Screens

@Composable
fun MainColorCard(
    modifier: Modifier = Modifier,
    currentColorItem: ColorsItem,
    navController: NavController,
) {
    val rememberImagePainter =
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(currentColorItem.badgeUrl).build(),
        )

    Column(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(12.dp)
    ) {
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable {
                           navController.navigate(
                               Screens.DetailsScreen.passPaintDetails(
                                   imageUrl = currentColorItem.badgeUrl ?: "",
                                   imageTitle = currentColorItem.title ?: "",
                                   imageUsername = currentColorItem.userName ?: "",
                               )
                           )
                    // for navigate to the details screen
                },
            painter = rememberImagePainter,
            contentDescription = "Empty",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Column {
                Text(
                    text = currentColorItem.title ?: "Empty",
                    fontSize = 18.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = currentColorItem.userName ?: "Empty",
                    fontSize = 14.sp,
                    color = DarkGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }
}