package com.svkhackathon.kkilook.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(imageList: List<String>) {
    val pagerState = rememberPagerState(pageCount = {
        imageList.size
    })
    Box {
        HorizontalPager(state = pagerState) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .aspectRatio(1f),
            ) {
                ImageByUrl(
                    url = imageList[page],
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "slider image"
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewImgSlider() {
    ImageSlider(
        listOf(
            "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
            "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
            "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
        )
    )
}