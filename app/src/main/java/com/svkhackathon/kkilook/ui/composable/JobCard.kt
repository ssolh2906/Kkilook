package com.svkhackathon.kkilook.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JobCard(
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(12.dp)
            .shadow(10.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onCardClick() }
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Column(modifier.weight(1f)) {
                Text(text = "정규직", style = TextStyle.Default)
                Text(
                    text = "[피카츄 산책시키기] 산책 경력있는 신입 구합니다",
                    style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.Start) {
                    Text(text = "San Jose", style = TextStyle.Default.copy(color = Color.Gray))
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(text = "MON-FRI", style = TextStyle.Default.copy(color = Color.Gray))
                }
                Text(text = "세금보고 가능 / 탄력적인 스케쥴 / 고무장갑 지참", style = TextStyle.Default.copy(color = Color.Gray))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "$5 / Hr", style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp))
            }
            Spacer(modifier = Modifier.size(12.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically).weight(0.12f),
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PreviewJobCard() {
    JobCard {}
}