package com.svkhackathon.kkilook.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.svkhackathon.kkilook.RandomRank
import com.svkhackathon.kkilook.ui.theme.Brown10
import com.svkhackathon.kkilook.ui.theme.Brown80

@Composable
fun CommentBox() {
    Column(
        Modifier
            .padding(12.dp)
            .fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "댓글",
            modifier = Modifier.padding(12.dp),
            style = TextStyle.Default.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp)
        )
        Comment(
            user = "지우",
            userProfileUrl = "https://i.pinimg.com/736x/18/d9/e1/18d9e1307018dbc76750ca7d5124fccd.jpg",
            comment = "살려줘"
        )

        Comment(
            user = "웅이",
            userProfileUrl = "https://staticg.sportskeeda.com/editor/2021/01/94117-16113018527605-800.jpg",
            comment = "어림도없다 요녀석",
            isReply = true
        )
        Comment(
            user = "사토시",
            userProfileUrl = "https://i.pinimg.com/736x/18/d9/e1/18d9e1307018dbc76750ca7d5124fccd.jpg",
            comment = "저녀석은 가짜에요"
        )
        Spacer(modifier = Modifier.height(12.dp))
        CommentInput()
    }
}

@Composable
fun CommentInput() {
    val text = remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text.value,
        onValueChange = {
            text.value = it
        },
        placeholder = {
            Text(text = "댓글을 입력해주세요")
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Brown80,
            unfocusedContainerColor = Brown80,
            cursorColor = Brown10,
            focusedIndicatorColor = Brown10,
            unfocusedIndicatorColor = Brown10,
        )
    )
}

@Composable
fun Comment(
    user: String,
    userProfileUrl: String,
    comment: String,
    isReply: Boolean = false
) {
    val randomRank = RandomRank()
    Row {
        if (isReply) {
            Spacer(modifier = Modifier.size(24.dp))
        }
        ImageByUrl(
            url = userProfileUrl,
            modifier = Modifier
                .border(1.dp, Color.LightGray, shape = CircleShape)
                .size(36.dp)
                .clip(CircleShape)
                .background(color = Color.LightGray),
            contentDescription = "Profile picture"
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = user, style = TextStyle.Default.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.width(8.dp))
                Image(painterResource(id =randomRank.invoke()), null, modifier = Modifier.size(18.dp))
            }
            Text(text = comment)
            Text(
                text = "yesterday",
                style = TextStyle.Default.copy(color = Color.Gray, fontSize = 14.sp)
            )
        }
    }
}

@Composable
@Preview
fun PreviewComments() {
    CommentBox()
}