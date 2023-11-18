package com.svkhackathon.kkilook.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


@Composable
fun MenuDialog(
    items: List<String>,
    onFilterChanged: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            items.onEach {
                MenuItem(text = it, onFilterChanged, onDismissRequest)
            }
        }
    }
}

@Composable
fun MenuItem(text: String, onFilterChanged: (String) -> Unit, onDismissRequest: () -> Unit) {
    Text(text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(12.dp)
            .clickable {
                onDismissRequest()
                onFilterChanged(text)
            }
    )
}
