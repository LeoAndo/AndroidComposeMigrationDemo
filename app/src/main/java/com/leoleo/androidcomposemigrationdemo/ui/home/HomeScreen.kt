package com.leoleo.androidcomposemigrationdemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.leoleo.androidcomposemigrationdemo.R
import com.leoleo.androidcomposemigrationdemo.data.User
import com.leoleo.androidcomposemigrationdemo.ui.AppSurface
import com.leoleo.androidcomposemigrationdemo.ui.PreviewPhoneDevice

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    HomeScreenStateless(
        modifier = modifier,
        uiState = viewModel.uiState,
        onClickGetUsersBtn = { viewModel.getUsers() })
}

@Composable
private fun HomeScreenStateless(
    modifier: Modifier = Modifier,
    uiState: UiState,
    onClickGetUsersBtn: () -> Unit
) {
    AppSurface(modifier) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { onClickGetUsersBtn() }) {
                Text("getUsers")
            }
            when (uiState) {
                Initial -> {}
                Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            uiState.message,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.wrapContentSize()
                        )
                    }
                }

                is Data -> {
                    LazyColumn {
                        uiState.users.forEachIndexed { _, user ->
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    elevation = 4.dp,
                                    shape = RoundedCornerShape(12.dp),
                                ) {
                                    Row {
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_icon),
                                            contentScale = ContentScale.Fit,
                                            contentDescription = "application icon",
                                            modifier = Modifier.size(54.dp)
                                        )
                                        Spacer(modifier = Modifier.size(16.dp))
                                        Column {
                                            val style = MaterialTheme.typography.body1
                                            Text(
                                                text = user.name,
                                                style = style,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
                                            )
                                            Text(
                                                text = user.age.toString(),
                                                style = style,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis,
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.size(2.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@PreviewPhoneDevice
@Composable
private fun Prev_HomeScreen_Initial() {
    HomeScreenStateless(uiState = Initial, onClickGetUsersBtn = {})
}

@PreviewPhoneDevice
@Composable
private fun Prev_HomeScreen_Loading() {
    HomeScreenStateless(uiState = Loading, onClickGetUsersBtn = {})
}

@PreviewPhoneDevice
@Composable
private fun Prev_HomeScreen_Data() {
    val testData = buildList { repeat(5) { add(User(it, "Tanaka $it", 10 + it)) } }
    HomeScreenStateless(uiState = Data(users = testData), onClickGetUsersBtn = {})
}

@PreviewPhoneDevice
@Composable
private fun Prev_HomeScreen_Error() {
    HomeScreenStateless(uiState = Error(message = "error!!!"), onClickGetUsersBtn = {})
}