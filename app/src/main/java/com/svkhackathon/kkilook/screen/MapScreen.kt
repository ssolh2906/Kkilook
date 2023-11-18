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
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.svkhackathon.kkilook.Page
import com.svkhackathon.kkilook.R
import java.lang.Math.random

const val ROUTE_MAP = "route_map"

@Composable
fun MapScreen(page: String?) {
    val coordinate = remember { mutableStateOf<LayoutCoordinates?>(null) }

    val iconVector = when (page) {
        Page.Job.name -> Icons.Default.AccountBox
        Page.Market.name -> Icons.Default.FavoriteBorder
        Page.Housing.name -> Icons.Default.Home
        else -> null
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .onGloballyPositioned {
            coordinate.value = it
        }) {
        Image(
            painter = painterResource(id = R.drawable.map2),
            contentDescription = "map",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Pointer(
            modifier = Modifier
                .size(100.dp)
                .offset(
                    x = randomPositionX(coordinate = coordinate),
                    y = randomPositionY(coordinate = coordinate)
                ),
            iconVector = iconVector
        )
        Pointer(
            modifier = Modifier
                .size(50.dp)
                .offset(
                    x = randomPositionX(coordinate = coordinate),
                    y = randomPositionY(coordinate = coordinate)
                ),
            iconVector = iconVector
        )
        Pointer(
            modifier = Modifier
                .size(70.dp)
                .offset(
                    x = randomPositionX(coordinate = coordinate),
                    y = randomPositionY(coordinate = coordinate)
                ),
            iconVector = iconVector
        )
    }
}

@Composable
private fun randomPositionY(coordinate: MutableState<LayoutCoordinates?>): Dp {
    val dpMultiplier = 1 / (with(LocalDensity.current) { 1.dp.toPx() })
    val h = (coordinate.value?.size?.height ?: 1080) * dpMultiplier - 100
    return (random() * 1000)
        .toInt()
        .mod(h.toInt()).dp
}

@Composable
private fun randomPositionX(coordinate: MutableState<LayoutCoordinates?>): Dp {
    val dpMultiplier = 1 / (with(LocalDensity.current) { 1.dp.toPx() })
    val w = (coordinate.value?.size?.width ?: 1080) * dpMultiplier - 100
    return (random() * 1000)
        .toInt()
        .mod(w.toInt()).dp
}

@Composable
fun Pointer(modifier: Modifier, iconVector: ImageVector?) {
    Box(
        modifier = modifier
            .shadow(10.dp, clip = false)
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .border(2.dp, Color.Blue, shape = RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Icon(
            imageVector = iconVector ?: Icons.Default.Email,
            contentDescription = "Pointer on map",
            tint = Color.Blue,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
fun PreviewMapScreen() {
    MapScreen("")
}