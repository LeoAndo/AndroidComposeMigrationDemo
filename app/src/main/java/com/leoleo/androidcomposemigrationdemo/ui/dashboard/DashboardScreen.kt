package com.leoleo.androidcomposemigrationdemo.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.leoleo.androidcomposemigrationdemo.ui.AppSurface
import com.leoleo.androidcomposemigrationdemo.ui.PreviewPhoneDevice

@Composable
fun DashboardScreen(modifier: Modifier = Modifier, viewModel: DashboardViewModel) {
    val text by viewModel.text.observeAsState("Hello!!")
    DashboardScreenStateless(modifier = modifier, text = text)
}

@Composable
private fun DashboardScreenStateless(modifier: Modifier = Modifier, text: String) {
    AppSurface(modifier) {
        Text(text, style = MaterialTheme.typography.body1, modifier = Modifier.wrapContentSize())
    }
}

@PreviewPhoneDevice
@Composable
private fun Prev_DashboardScreen() {
    DashboardScreenStateless(
        modifier = Modifier.fillMaxSize(),
        text = "Hello, DashboardScreen"
    )
}