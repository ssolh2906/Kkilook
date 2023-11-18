package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.svkhackathon.kkilook.ui.composable.ImageSlider

const val ROUTE_ITEM_DETAIL = "route_item_detail"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemDetailScreen(
    id: String?
) {
    val images = listOf(
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
    )
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0.1f) { images.size }

    Column {
//        Card(
//            modifier = Modifier.padding(16.dp),
//        ) {
//            ImageSlider(
//                itemsCount = images.size,
//                itemContent = { index ->
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(images[index])
//                            .build(),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                },
//                autoSlideDuration = 0,
//                pagerState = pagerState
//            )
//        }



        Text(text = id ?: "null")

    }
}

@Composable
@Preview
fun PreviewItemDetailScreen() {
    ItemDetailScreen(id = "")
}