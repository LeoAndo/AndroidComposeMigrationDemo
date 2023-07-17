package com.leoleo.androidcomposemigrationdemo.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.jvm.Throws
import kotlin.random.Random

class UserRepository(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    @Throws(Exception::class)
    suspend fun getUsers(): List<User> {
        return withContext(dispatcher) {
            delay(2000L) // 時間乗っかる処理をmock
            if (Random.nextBoolean()) { // ランダムでExceptionをthrowさせる
                throw Exception("getUsers error-----!!!")
            }
            buildList { repeat(5) { add(User(it, "Tanaka $it", 10 + it)) } }
        }
    }
}