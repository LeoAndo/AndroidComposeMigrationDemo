package com.leoleo.androidcomposemigrationdemo.ui.notifications

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.leoleo.androidcomposemigrationdemo.ui.AppSurface
import com.leoleo.androidcomposemigrationdemo.ui.PreviewPhoneDevice

@Composable
fun NotificationsScreen(modifier: Modifier = Modifier, viewModel: NotificationsViewModel) {
    val text by viewModel.text.observeAsState("Hello!!")
    NotificationsScreenStateless(modifier = modifier, text = text)
}

@Composable
private fun NotificationsScreenStateless(modifier: Modifier = Modifier, text: String) {
    AppSurface(modifier) {
        Text(text, style = MaterialTheme.typography.body1, modifier = Modifier.wrapContentSize())
    }
}

@PreviewPhoneDevice
@Composable
private fun Prev_NotificationsScreen() {
    NotificationsScreenStateless(
        modifier = Modifier.fillMaxSize(),
        text = "Hello, NotificationsScreen"
    )
}