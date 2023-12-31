package com.svkhackathon.kkilook.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ImageByUrl(
    url: String = "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
    modifier: Modifier,
    contentDescription: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(
                url
            )
            .crossfade(true)
            .build(),
        modifier = modifier,
        contentScale = ContentScale.Crop,
        contentDescription = contentDescription,
    )
}