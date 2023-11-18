package com.svkhackathon.kkilook.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MarketItem() {

    Box(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row {
            ImageByUrl(
                url = "https://storage.qoo-img.com/avatar/sns/18/40288218_87125.jpg",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentDescription = "merchant image"
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = "메타몽팝니다",
                    style = TextStyle.Default.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Text(
                    text = "San Jose / 10 miles",
                    style = TextStyle.Default.copy(
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                )
                Text(
                    text = "1200 $",
                    style = TextStyle.Default.copy(
                        fontWeight = FontWeight.Black,
                        fontSize = 22.sp
                    )
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()) {
                    Row(modifier = Modifier.align(Alignment.BottomEnd)) {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = "Icon heart",
                            tint = Color.Gray
                        )
                        Text(text = "1", color = Color.Gray)
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewMarketItems() {
    MarketItem()
}