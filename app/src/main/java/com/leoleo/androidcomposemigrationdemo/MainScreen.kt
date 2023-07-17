package com.leoleo.androidcomposemigrationdemo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.leoleo.androidcomposemigrationdemo.ui.AppSurface
import com.leoleo.androidcomposemigrationdemo.ui.PreviewPhoneDevice
import com.leoleo.androidcomposemigrationdemo.ui.dashboard.DashboardScreen
import com.leoleo.androidcomposemigrationdemo.ui.dashboard.DashboardViewModel
import com.leoleo.androidcomposemigrationdemo.ui.home.HomeScreen
import com.leoleo.androidcomposemigrationdemo.ui.home.HomeViewModel
import com.leoleo.androidcomposemigrationdemo.ui.notifications.NotificationsScreen
import com.leoleo.androidcomposemigrationdemo.ui.notifications.NotificationsViewModel

enum class BottomItem(val label: String, @DrawableRes val iconId: Int) {
    Home("Home", R.drawable.ic_home_black_24dp),
    Dashboard("Dashboard", R.drawable.ic_dashboard_black_24dp),
    Notifications("Notifications", R.drawable.ic_notifications_black_24dp)
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    dashboadViewModel: DashboardViewModel,
    notificationsViewModel: NotificationsViewModel
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val items = BottomItem.values()
    AppSurface(modifier) {
        Scaffold(
            topBar = {
                TopAppBar {
                    Text(text = items.first { it.ordinal == selectedIndex }.label)
                }
            },
            bottomBar = {
                BottomNavigation {
                    items.forEachIndexed { index, item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painterResource(id = item.iconId),
                                    contentDescription = item.label
                                )
                            },
                            label = { Text(item.label) },
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index }
                        )
                    }
                }
            }, content = {
                when (items.first { item -> item.ordinal == selectedIndex }) {
                    BottomItem.Home -> HomeScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(it)
                    )

                    BottomItem.Dashboard -> DashboardScreen(
                        viewModel = dashboadViewModel,
                        modifier = Modifier.padding(it)
                    )

                    BottomItem.Notifications -> NotificationsScreen(
                        viewModel = notificationsViewModel,
                        modifier = Modifier.padding(it)
                    )
                }
            })
    }
}

@PreviewPhoneDevice
@Composable
fun Prev_MainScreen() {
    MainScreen(
        viewModel = HomeViewModel(),
        dashboadViewModel = DashboardViewModel(),
        notificationsViewModel = NotificationsViewModel()
    )
}