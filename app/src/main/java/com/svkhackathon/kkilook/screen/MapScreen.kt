package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.svkhackathon.kkilook.R

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
        Pointer(
            modifier = Modifier
                .size(100.dp)
                .offset(100.dp, 150.dp)
        )
        Pointer(
            modifier = Modifier
                .size(50.dp)
                .offset(200.dp, 20.dp)
        )
        Pointer(
            modifier = Modifier
                .size(70.dp)
                .offset(300.dp, 400.dp)
        )
    }
}

@Composable
fun Pointer(modifier: Modifier) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .border(2.dp, Color.Blue, shape = RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Icon(
            Icons.Default.Email, contentDescription = "Pointer on map",
            tint = Color.Blue,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
fun PreviewMapScreen() {
    MapScreen()
}