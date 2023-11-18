package com.svkhackathon.kkilook.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HousingCard(
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit
) {
    val housePictures = listOf<String>(
        "https://www.bankrate.com/2022/09/13091209/tips-for-selling-your-home.jpg?auto=webp&optimize=high&crop=16:9",
        "https://ap.rdcpix.com/6fec7821ca4c763b51ac15c764c5eef1l-b240479861od-w480_h360.jpg"
    )

    Surface(
        modifier = modifier
            .padding(12.dp)
            .shadow(10.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onCardClick() }
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            ImageSlider(imageList = housePictures, aspectRatio = 1.6f)
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Expensive Sketchy Old Apt Near By Rich Town",
                style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "123 Ariana Grande Way, Los Gatos, CA", style = TextStyle.Default)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "1 Bed 1 Bath", style = TextStyle.Default)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$1000 / night",
                style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
        }
    }
}
