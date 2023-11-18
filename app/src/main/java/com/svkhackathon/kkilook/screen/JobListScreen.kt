package com.svkhackathon.kkilook.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.svkhackathon.kkilook.ui.composable.JobCard
import com.svkhackathon.kkilook.ui.composable.MenuDialog

const val ROUTE_JOB_LIST = "route_job_list"

@Composable
fun JobListScreen(onItemClick: () -> Unit) {
    val jobMenuList = listOf(
        "지역",
        "시급",
        "직종",
        "근무기간"
    )

    val openDialog = remember { mutableStateOf(false) }
    val filter = remember { mutableStateOf("지역") }

    if (openDialog.value) {
        MenuDialog(items = jobMenuList, onFilterChanged = {
            filter.value = it
        }) {
            openDialog.value = false
        }
    }

    Column {
        SubTopBar(currFilter = filter.value, onFilterClick = { openDialog.value = true })

        LazyColumn {
            for (i in 0..10) {
                item() {
                    JobCard(onCardClick = onItemClick)
                }
            }
        }
    }
}