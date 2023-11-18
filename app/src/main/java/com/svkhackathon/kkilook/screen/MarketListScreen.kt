package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.svkhackathon.kkilook.ui.composable.MarketItem
import com.svkhackathon.kkilook.ui.composable.MenuDialog

const val ROUTE_MARKET_LIST = "route_market_list"

@Composable
fun MarketListScreen(onItemClick: () -> Unit) {
    val item = MarketItemState(
        "메타몽",
        "San jose, 10 mi",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
    )
    val marketMenuList = listOf(
        "최신순",
        "낮은가격순",
        "높은가격순"
    )

    val openDialog = remember { mutableStateOf(false) }
    val filter = remember { mutableStateOf("추천순") }

    if (openDialog.value) {
        MenuDialog(items = marketMenuList, onFilterChanged = {
            filter.value = it
        }) {
            openDialog.value = false
        }
    }

    val merchantList = listOf<MarketItemState>(
        item, item, item, item, item
    )
    Column {
        MarketTopBar(currFilter = filter.value, onFilterClick = {openDialog.value = true})

        LazyColumn {
            items(merchantList.size) {
                MarketItem(onItemClick = onItemClick)
            }
        }
    }
}

@Composable
fun MarketTopBar(currFilter:String, onFilterClick: ()-> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .padding(horizontal = 12.dp)
    ) {
        Row(modifier = Modifier.align(Alignment.CenterEnd).clickable { onFilterClick() }) {
            Icon(Icons.Default.ArrowDropDown, contentDescription = "sort")
            Text(text = currFilter, color = Color.Gray)
        }
    }
}

data class MarketItemState(
    val title: String,
    val region: String,
    val imageUrl: String
)