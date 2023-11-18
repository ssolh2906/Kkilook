package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.svkhackathon.kkilook.ui.composable.MarketItem

const val ROUTE_MARKET_LIST = "route_market_list"

@Composable
fun MarketListScreen(onItemClick: () -> Unit) {
    val item = MarketItemState(
        "메타몽",
        "San jose, 10 mi",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
    )

    val merchantList = listOf<MarketItemState>(
        item, item, item, item, item
    )

    LazyColumn {
        items(merchantList.size) {
            MarketItem(onItemClick = onItemClick)
        }
    }
}

data class MarketItemState(
    val title: String,
    val region: String,
    val imageUrl: String
)