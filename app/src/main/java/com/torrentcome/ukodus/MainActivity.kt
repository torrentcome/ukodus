package com.torrentcome.ukodus

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.torrentcome.ukodus.data.*
import com.torrentcome.ukodus.ui.screen.MainScreen
import com.torrentcome.ukodus.ui.theme.Theme

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val store = Store(
        State.Init,
        null
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Theme(darkTheme = true) {
                MainScreen(
                    state = store,
                    load = {
                        store.state = State.Load
                        store.board = board
                    },
                    solve = {
                        store.state = State.Solve
                        store.board?.let { viewModel.solve(it, it.size) }
                    },
                    quit = {
                        finish()
                    }
                )
            }
        }
    }
}
