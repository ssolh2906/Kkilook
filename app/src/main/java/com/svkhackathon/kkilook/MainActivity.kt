package com.svkhackathon.kkilook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.svkhackathon.kkilook.screen.ItemDetailScreen
import com.svkhackathon.kkilook.screen.MainScreen
import com.svkhackathon.kkilook.screen.ROUTE_ITEM_DETAIL
import com.svkhackathon.kkilook.screen.ROUTE_MAIN
import com.svkhackathon.kkilook.ui.theme.KkilookTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KkilookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()

                    Scaffold(
                        floatingActionButton = {
                            ExtendedFloatingActionButton(
                                text = { Text("Show drawer") },
                                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                                onClick = {
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                            )
                        }
                    ) {
                        ModalNavigationDrawer(
                            drawerState = drawerState,
                            drawerContent = {
                                ModalDrawerSheet {
                                    Text("Drawer title", modifier = Modifier.padding(16.dp))
                                    Divider()
                                    NavigationDrawerItem(
                                        label = { Text(text = "Drawer Item") },
                                        selected = false,
                                        onClick = { /*TODO*/ }
                                    )
                                    // ...other drawer items
                                }
                            }
                        ) {
                            KkilookApp("Hello Kkilook!", it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun KkilookApp(name: String, paddingValues: PaddingValues) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ROUTE_MAIN) {
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
                navController = navController,
                id = navEntry.arguments?.getString("id")
            )
        }
    }
}
