package com.torrentcome.ukodus

import androidx.lifecycle.ViewModel
import kotlin.math.sqrt


class MainViewModel : ViewModel() {

    fun solve(
        board: Array<IntArray>,
        n: Int
    ): Boolean {
        var row = -1
        var col = -1
        var isEmpty = true

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 0) {
                    row = i
                    col = j
                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false
                    break
                }
            }
            if (!isEmpty) {
                break
            }
        }

        // no empty space left
        if (isEmpty) {
            return true
        }

        // else for each-row backtrack
        (1..n).forEach { num ->
            if (isSafe(board, row, col, num)) {
                board[row][col] = num

                if (solve(board, n)) {
                    return true
                } else {
                    board[row][col] = 0
                }
            }
        }
        return false
    }


    private fun isSafe(
        board: Array<IntArray>,
        row: Int,
        col: Int,
        num: Int
    ): Boolean {
        // row has the unique (row-clash)
        board.indices.forEach { d ->
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false
            }
        }

        // column has the unique numbers (column-clash)
        board.indices.forEach { r ->
            // if the number we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num) {
                return false
            }
        }

        // corresponding square has
        // unique number (box-clash)
        val sqrt = sqrt(board.size.toDouble()).toInt()
        val boxRowStart = row - row % sqrt
        val boxColStart = col - col % sqrt
        for (r in boxRowStart until boxRowStart + sqrt) {
            for (d in boxColStart until boxColStart + sqrt) {
                if (board[r][d] == num) {
                    return false
                }
            }
        }

        // if there is no clash, it's safe
        return true
    }
}
