package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.svkhackathon.kkilook.ui.composable.ImageByUrl

const val ROUTE_MAP = "route_map"

@Composable
fun MapScreen(
) {
    Box(modifier = Modifier.fillMaxSize()) {

        ImageByUrl(
            url = "https://www.google.com/maps/d/thumbnail?mid=1JXudFgRmzNUU_cp6SY6X-Vgvl2o&hl=en",
            modifier = Modifier.fillMaxSize(),
            contentDescription = "map"
        )
    }
}

@Composable
fun Pointer(modifier: Modifier) {

}