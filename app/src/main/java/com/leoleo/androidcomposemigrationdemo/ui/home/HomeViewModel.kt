package com.leoleo.androidcomposemigrationdemo.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoleo.androidcomposemigrationdemo.data.Container
import com.leoleo.androidcomposemigrationdemo.data.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: UserRepository = Container.userRepository,
) : ViewModel() {
    var uiState by mutableStateOf<UiState>(Initial)
        private set
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        uiState = Error(message = throwable.localizedMessage.ifEmpty { "error.." })
    }

    fun getUsers() {
        viewModelScope.launch(exceptionHandler) {
            uiState = Loading
            uiState = Data(users = repository.getUsers())
        }
    }
}