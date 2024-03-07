package com.example.dotify_kotlin.features.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dotify_kotlin.features.core.presentation.main_tab.home.HomeTab
import com.example.dotify_kotlin.features.core.presentation.main_tab.library.LibraryTab
import com.example.dotify_kotlin.features.core.presentation.main_tab.search.SearchTab
import com.example.dotify_kotlin.routes.playlistDetail

data class NavBarItemData(
    val icon:ImageVector,
    val selectedIcon:ImageVector,
    val label:String,
    val tab: @Composable () -> Unit
)

@Composable
fun MainScreen(
    overallController: NavController
) {
    val mainNavController = rememberNavController()

    val navBarItems = listOf(
        NavBarItemData(
            icon = Icons.Filled.Home,
            selectedIcon = Icons.Filled.Home,
            label = "Home",
           tab = { HomeTab() }
        ),
        NavBarItemData(
            icon = Icons.Filled.Search,
            selectedIcon = Icons.Filled.Search,
            label = "Search",
            tab = {SearchTab()}
        ), NavBarItemData(
            icon = Icons.Filled.Menu,
            selectedIcon = Icons.Filled.Menu,
            label = "Library",
            tab = { LibraryTab(mainNavController) }
        )
    )
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }


    Scaffold(
        content = {
            Box(Modifier.padding(it)) {
                NavHost(navController = mainNavController, startDestination =  "Home") {
                    navBarItems.forEach {i ->
                        composable(i.label) { i.tab.invoke() }
                    }
                    playlistDetail()
                    // Add more destinations similarly.
                }
            }
        },
        bottomBar = {
            NavigationBar (
                containerColor= Color.Black,
                contentColor = Color.White
            ) {
                navBarItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                            mainNavController.navigate(
                                item.label
                            )
                        },
                        label = {
                            Text(text = item.label)
                        },
                        icon = {
                            Icon(
                                imageVector =
                                if (index == selectedIndex)
                                    item.selectedIcon
                                else
                                    item.icon,
                                contentDescription = item.label
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White
                        )
                    )
                }

            }
        }
    )
}

