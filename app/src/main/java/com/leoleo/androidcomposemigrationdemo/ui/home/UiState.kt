package com.leoleo.androidcomposemigrationdemo.ui.home

import com.leoleo.androidcomposemigrationdemo.data.User

sealed interface UiState
object Initial : UiState
data class Data(val users: List<User>) : UiState
object Loading : UiState
data class Error(val message: String) : UiState