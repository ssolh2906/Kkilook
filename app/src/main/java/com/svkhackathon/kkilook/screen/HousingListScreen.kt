package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.svkhackathon.kkilook.ui.composable.HousingCard

const val ROUTE_HOUSING_LIST = "route_housing_list"

@Composable
fun HousingListScreen(onItemClick: () -> Unit) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        HousingCard()
        HousingCard()
        HousingCard()
        HousingCard()
    }
}

@Preview
@Composable
fun PreviewHousingList() {
    HousingListScreen {}
}