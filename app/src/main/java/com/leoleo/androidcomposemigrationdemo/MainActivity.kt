package com.leoleo.androidcomposemigrationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import com.leoleo.androidcomposemigrationdemo.ui.dashboard.DashboardViewModel
import com.leoleo.androidcomposemigrationdemo.ui.home.HomeViewModel
import com.leoleo.androidcomposemigrationdemo.ui.notifications.NotificationsViewModel

class MainActivity : ComponentActivity() {
    private val homeViewModel by viewModels<HomeViewModel>()
    private val dashboardViewModel by viewModels<DashboardViewModel>()
    private val notificationsViewModel by viewModels<NotificationsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                viewModel = homeViewModel,
                dashboadViewModel = dashboardViewModel,
                notificationsViewModel = notificationsViewModel
            )
        }
    }
}