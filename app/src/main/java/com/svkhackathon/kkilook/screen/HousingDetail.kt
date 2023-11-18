package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.svkhackathon.kkilook.R
import com.svkhackathon.kkilook.ui.composable.ImageSlider
import com.svkhackathon.kkilook.ui.composable.Profile

const val ROUTE_HOUSING_DETAIL = "route_housing_detail"

@Composable
fun HousingDetailScreen() {
    val images = listOf(
        "https://img2.cgtrader.com/items/735152/0d8ed7db58/large/old-room-3d-model-max-fbx.jpg",
        "https://images.squarespace-cdn.com/content/v1/595ad38e2cba5e4e487fa51d/1637506417934-T5IIXJKW6ZDL84AI2U9X/Bob-8.jpg",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
    )

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        ImageSlider(imageList = images)
//        Text(text = id ?: "null")
        Text(
            text = "귀신씨나락까먹는소리가들리는집",
            style = TextStyle.Default.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(12.dp)
        )

        Text(
            text = "$300 / night",
            style = TextStyle.Default.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.End),
            modifier = Modifier.padding(12.dp).fillMaxWidth()
        )

        Profile()

        Text(
            text = "안녕하세요 하루 자고가세요 \n비싸요?\n이것이 실리-코ㄴ 밸리의 매콤함이야!\n\n꼬우면노숙하든지.",
            modifier = Modifier.padding(12.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "위치", style = TextStyle.Default.copy(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Los Gatos", style = TextStyle.Default.copy(color = Color.Gray))
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.map2),
                contentDescription = "map",
                modifier = Modifier.fillMaxSize()
            )

        }
    }
}

@Composable
@Preview
fun PreviewHousingDetail() {
    HousingDetailScreen()
}