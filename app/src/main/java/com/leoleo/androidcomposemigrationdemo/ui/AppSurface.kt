package com.leoleo.androidcomposemigrationdemo.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.leoleo.androidcomposemigrationdemo.ui.theme.AndroidComposeMigrationDemoTheme

@Composable
fun AppSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    AndroidComposeMigrationDemoTheme {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .windowInsetsPadding(insets = WindowInsets.safeDrawing),
        ) {
            content()
        }
    }
}

@PreviewPhoneDevice
@Composable
fun Prev_AppSurface() {
    AppSurface {
        Text(text = "Hello, Compose!", modifier = Modifier.wrapContentSize())
    }
}