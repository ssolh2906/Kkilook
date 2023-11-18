package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.svkhackathon.kkilook.R
import com.svkhackathon.kkilook.ui.composable.CommentBox
import com.svkhackathon.kkilook.ui.composable.Profile
import com.svkhackathon.kkilook.ui.theme.Brown10

const val ROUTE_JOB_DETAIL = "route_job_detail"

@Composable
fun JobDetailScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "피카츄 산책 정규직 구인합니다",
                style = TextStyle.Default.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(12.dp)
                    .weight(0.7f)
            )

            Text(
                text = "Cupertino",
                style = TextStyle.Default.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
                    .padding(4.dp)
                    .weight(0.3f)
            )

        }

        Button(onClick = {}, modifier = Modifier.fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Brown10,
            )) {
            Text(text = "지원하기")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .padding(top = 12.dp)
        ) {
            Text(
                text = "시급",
                style = TextStyle.Default.copy(fontSize = 14.sp, color = Color.Gray),
            )

            Text(
                text = "$ 5",
                style = TextStyle.Default.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            )

            VerticalDivider()

            Text(
                text = "기간",
                style = TextStyle.Default.copy(fontSize = 14.sp, color = Color.Gray),
            )

            Text(
                text = "1년 이상",
                style = TextStyle.Default.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            )
            VerticalDivider()
            Text(
                text = "시간",
                style = TextStyle.Default.copy(fontSize = 14.sp, color = Color.Gray),
            )

            Text(
                text = "5:00 AM - 10:00 PM",
                style = TextStyle.Default.copy(fontSize = 14.sp, fontWeight = FontWeight.Bold),
            )

        }

        Divider()

        Profile()

        Condition()

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

        CommentBox()
    }
}

@Composable
fun Condition() {
    Column(
        Modifier
            .padding(12.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(12.dp))
            .padding(vertical = 6.dp)
    ) {
        ConditionItem("학력", "학력무관")
        ConditionItem("나이", "50+")
        ConditionItem("우대사항", "전기 내성이 강한 자")
    }
}

@Composable
private fun ConditionItem(title:String, description:String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 6.dp)) {
        Text(
            text = title,
            style = TextStyle.Default.copy(color = Color.Gray),
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = description,
            modifier = Modifier.weight(0.7f)
        )
    }
}

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    thickness: Dp = 1.dp
) {
    Box(
        modifier
            .fillMaxHeight()
            .width(thickness)
            .background(color = color)
    )
}

@Composable
@Preview
fun PreviewJobDetailScreen() {
    JobDetailScreen()
}