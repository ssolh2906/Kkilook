package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.svkhackathon.kkilook.R
import com.svkhackathon.kkilook.ui.composable.ImageByUrl

const val ROUTE_MAP = "route_map"

@Composable
fun MapScreen(
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = "map",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Pointer(modifier: Modifier) {

}

@Composable
@Preview
fun PreviewMapScreen() {
    MapScreen()
}