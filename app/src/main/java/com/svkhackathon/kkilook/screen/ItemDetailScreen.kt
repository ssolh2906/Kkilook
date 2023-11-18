package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.svkhackathon.kkilook.R
import com.svkhackathon.kkilook.ui.composable.ImageSlider
import com.svkhackathon.kkilook.ui.composable.Profile

const val ROUTE_ITEM_DETAIL = "route_item_detail"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemDetailScreen(
    id: String?
) {
    val images = listOf(
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
        "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
    )

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        ImageSlider(imageList = images)
//        Text(text = id ?: "null")
        Text(
            text = "메타몽 256 판매",
            style = TextStyle.Default.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(12.dp)
        )

        Profile()

        Text(
            text = "안녕하세요 메타몽 256사이즈 팝니다. \n말 잘 들어요\n\n그리고아무튼 귀엽습니다.",
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
                painter = painterResource(id = R.drawable.map),
                contentDescription = "map",
                modifier = Modifier.fillMaxSize()
            )

        }
    }
}

@Composable
@Preview
fun PreviewItemDetailScreen() {
    ItemDetailScreen(id = "")
}