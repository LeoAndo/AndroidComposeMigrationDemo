package com.leoleo.androidcomposemigrationdemo.ui

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers

@Preview(
    name = "Phone Landscape",
    device = Devices.PHONE,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
annotation class PreviewPhoneDevice

@Preview(
    showBackground = true,
    device = Devices.TABLET,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Tablet",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
annotation class PreviewTabletDevice

@Preview(
    showBackground = true,
    device = Devices.FOLDABLE,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Foldable",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
annotation class PreviewFoldableDevice

@Preview(
    showBackground = true,
    device = Devices.DESKTOP,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Desktop",
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
)
annotation class PreviewDesktopDevice

@PreviewPhoneDevice
@PreviewTabletDevice
@PreviewFoldableDevice
@PreviewDesktopDevice
annotation class PreviewDevices