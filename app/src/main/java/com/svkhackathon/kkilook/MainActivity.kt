package com.svkhackathon.kkilook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.svkhackathon.kkilook.screen.ItemDetailScreen
import com.svkhackathon.kkilook.screen.MainScreen
import com.svkhackathon.kkilook.screen.ROUTE_ITEM_DETAIL
import com.svkhackathon.kkilook.screen.ROUTE_MAIN
import com.svkhackathon.kkilook.ui.theme.KkilookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KkilookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KkilookApp("Hello Kkilook!")
                }
            }
        }
    }
}

@Composable
fun KkilookApp(name: String) {

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
