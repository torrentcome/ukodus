package com.torrentcome.ukodus.ui.compo

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Table(board: Array<IntArray>) {
    Column {
        (0 until 9).forEach { i ->
            Row {
                for (j in 0 until 9) {
                    Text(modifier = Modifier.padding(2.dp), text = "${board[i][j]}")
                }
            }
        }
    }
}
