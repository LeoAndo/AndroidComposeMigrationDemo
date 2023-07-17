package com.leoleo.androidcomposemigrationdemo.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoleo.androidcomposemigrationdemo.data.Container
import com.leoleo.androidcomposemigrationdemo.data.UserRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: UserRepository = Container.userRepository,
) : ViewModel() {
    val uiState = MutableLiveData<UiState>(Initial)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        uiState.value = Error(message = throwable.localizedMessage.ifEmpty { "error.." })
    }

    fun getUsers() {
        viewModelScope.launch(exceptionHandler) {
            uiState.value = Loading
            uiState.value = Data(users = repository.getUsers())
        }
    }
}