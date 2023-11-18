package com.svkhackathon.kkilook.ui.composable

import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.svkhackathon.kkilook.RandomRank
import com.svkhackathon.kkilook.ui.theme.Brown10
import com.svkhackathon.kkilook.ui.theme.Brown60
import java.lang.Math.round

@Composable
fun Profile(modifier: Modifier = Modifier) {
    val randomRank = RandomRank()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        ImageByUrl(
            url = "https://staticg.sportskeeda.com/editor/2021/01/94117-16113018527605-800.jpg",
            modifier = Modifier
                .border(1.dp, Color.LightGray, shape = CircleShape)
                .size(50.dp)
                .clip(CircleShape)
                .background(color = Color.LightGray),
            contentDescription = "Profile picture"
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = "웅이",
                style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
            Text(text = "늘 밥을 해줬어.", style = TextStyle.Default.copy(color = Color.Gray))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = randomRank.invoke()),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                val humidity = randomRank.randHumidity()
                Text(text = "습도 ${round(humidity * 100)} %")

                LinearProgressIndicator(
                    modifier = Modifier
                        .height(10.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    color = Brown10,
                    trackColor = Brown60,
                    progress = humidity
                )
            }
        }
    }
}