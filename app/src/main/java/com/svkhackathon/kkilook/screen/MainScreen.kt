package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.svkhackathon.kkilook.KkilookNavigation
import com.svkhackathon.kkilook.ui.theme.KkilookTheme

const val ROUTE_MAIN = "route_main"

@Composable
fun MainScreen(
    name: String,
    onButtonClick: (String) -> Unit,
) {
    var text by remember { mutableStateOf(name) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            }
        )

        Button(onClick = { onButtonClick(text) }) {
            Text(text = "navigate")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KkilookTheme {
        MainScreen("Android") {}
    }
}