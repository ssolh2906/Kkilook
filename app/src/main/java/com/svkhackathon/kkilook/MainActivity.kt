package com.svkhackathon.kkilook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.svkhackathon.kkilook.screen.HousingDetailScreen
import com.svkhackathon.kkilook.screen.HousingListScreen
import com.svkhackathon.kkilook.screen.ItemDetailScreen
import com.svkhackathon.kkilook.screen.MainScreen
import com.svkhackathon.kkilook.screen.MapScreen
import com.svkhackathon.kkilook.screen.MarketListScreen
import com.svkhackathon.kkilook.screen.ROUTE_HOUSING_DETAIL
import com.svkhackathon.kkilook.screen.ROUTE_HOUSING_LIST
import com.svkhackathon.kkilook.screen.ROUTE_ITEM_DETAIL
import com.svkhackathon.kkilook.screen.ROUTE_MAIN
import com.svkhackathon.kkilook.screen.ROUTE_MAP
import com.svkhackathon.kkilook.screen.ROUTE_MARKET_LIST
import com.svkhackathon.kkilook.ui.theme.KkilookTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KkilookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppScreen() {
    val navController = rememberNavController()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val currentPage = remember { mutableStateOf(Page.Market) }
    var checked by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = currentPage.value.string)
                },
                navigationIcon = {
                    Icon(
                        Icons.Filled.Menu,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        })
                },
                actions = {
                    Switch(
                        checked = checked,
                        onCheckedChange = { isMap ->
                            checked = isMap

                            if (isMap) {
                                navController.navigate(ROUTE_MAP)
                            } else {
                                when (currentPage.value) {
                                    Page.Job -> navController.navigate(ROUTE_MAIN)
                                    Page.Housing -> navController.navigate(ROUTE_HOUSING_LIST)
                                    Page.Market -> navController.navigate(ROUTE_MARKET_LIST)
                                }
                            }
                        },
                        thumbContent = if (checked) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = null,
                                    modifier = Modifier.size(SwitchDefaults.IconSize),
                                )
                            }
                        } else {
                            {
                                Icon(
                                    imageVector = Icons.Filled.List,
                                    contentDescription = null,
                                    modifier = Modifier.size(SwitchDefaults.IconSize),
                                )
                            }
                        }
                    )
                },
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        Text(
                            text = "Menu",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )
                        Divider()
                        NavigationDrawerItem(
                            icon = { Icon(Icons.Filled.KeyboardArrowRight, null) },
                            label = { Text(text = Page.Job.string) },
                            selected = false,
                            onClick = {
                                if (checked) {
                                    navController.navigate(ROUTE_MAP)
                                } else {
                                    navController.navigate("$ROUTE_MAP/${Page.Job.name}")
                                }
                                currentPage.value = Page.Job
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )

                        NavigationDrawerItem(
                            icon = { Icon(Icons.Filled.KeyboardArrowRight, null) },
                            label = { Text(text = Page.Housing.string) },
                            selected = false,
                            onClick = {
                                if (checked) {
                                    navController.navigate(ROUTE_MAP)
                                } else {
                                    navController.navigate(ROUTE_HOUSING_LIST)
                                }
                                currentPage.value = Page.Housing
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )

                        NavigationDrawerItem(
                            icon = { Icon(Icons.Filled.KeyboardArrowRight, null) },
                            label = { Text(text = Page.Market.string) },
                            selected = false,
                            onClick = {
                                if (checked) {
                                    navController.navigate(ROUTE_MAP)
                                } else {
                                    navController.navigate(ROUTE_MARKET_LIST)
                                }
                                currentPage.value = Page.Market
                                scope.launch {
                                    drawerState.apply {
                                        close()
                                    }
                                }
                            }
                        )
                        // ...other drawer items
                    }
                }
            ) {
                KkilookNavigation(navController = navController, "Hello Kkilook!", it, currentPage)
            }
        }
    }
}

@Composable
fun KkilookNavigation(
    navController: NavHostController,
    name: String,
    paddingValues: PaddingValues,
    currentPage: MutableState<Page>
) {

    NavHost(navController = navController, startDestination = "$ROUTE_MAP") {
        composable(ROUTE_MAIN) {
            MainScreen(
                name = name,
                onButtonClick = { id ->
                    navController.navigate("$ROUTE_ITEM_DETAIL/$id")
                }
            )
        }

        composable("$ROUTE_ITEM_DETAIL/{id}") { navEntry ->
            ItemDetailScreen(
                id = navEntry.arguments?.getString("id")
            )
        }


        composable(ROUTE_ITEM_DETAIL) { navEntry ->
            ItemDetailScreen("")
        }

        composable("$ROUTE_MAP/{page}") { navEntry ->
            MapScreen(
                page = navEntry.arguments?.getString("page")
            )
        }


        composable(ROUTE_MAP) { navEntry ->
            MapScreen(
                page = currentPage.value.name
            )
        }

        composable(ROUTE_MARKET_LIST) {
            MarketListScreen {
                navController.navigate(ROUTE_ITEM_DETAIL)
            }
        }

        composable(ROUTE_HOUSING_LIST) {
            HousingListScreen(onItemClick = { navController.navigate(ROUTE_HOUSING_DETAIL) })
        }

        composable(ROUTE_HOUSING_DETAIL) {
            HousingDetailScreen()
        }
    }
}

enum class Page(val string: String) {
    Job("구인구직"),
    Housing("렌트/하숙"),
    Market("마켓")
}