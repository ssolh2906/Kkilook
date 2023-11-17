package com.svkhackathon.kkilook.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

const val ROUTE_ITEM_DETAIL = "route_item_detail"

@Composable
fun ItemDetailScreen(
    navController: NavHostController,
    id: String?
) {
    Text(text = id ?: "null")
}
