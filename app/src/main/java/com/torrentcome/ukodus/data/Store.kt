package com.torrentcome.ukodus.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Store(state: State, board: Array<IntArray>?) {
    var state: State by mutableStateOf(state)
    var board: Array<IntArray>? by mutableStateOf(board)
}

sealed class State {
    object Init : State()
    object Load : State()
    object Solve : State()
}

val board: Array<IntArray> = arrayOf(
    intArrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
    intArrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
    intArrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
    intArrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
    intArrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
    intArrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
    intArrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
    intArrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
    intArrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
)