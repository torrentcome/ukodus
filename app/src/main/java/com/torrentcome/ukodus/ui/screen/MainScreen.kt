package com.torrentcome.ukodus.ui.screen

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.torrentcome.ukodus.data.Store
import com.torrentcome.ukodus.ui.compo.Table
import com.torrentcome.ukodus.ui.theme.White
import com.torrentcome.ukodus.data.State

@Composable
fun MainScreen(
    state: Store,
    load: () -> Unit,
    solve: () -> Unit,
    quit: () -> Unit
) {
    remember { state }

    Switch(
        checked = true,
        onCheckedChange = { }
    )

    when (state.state) {
        State.Init -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(modifier = Modifier.padding(2.dp), text = "Empty data here, wait for it...")
                Button(onClick = load) {
                    Text(
                        "Load",
                        style = TextStyle(color = White)
                    )
                }
            }
        }
        State.Load -> {
            Box(modifier = Modifier.fillMaxSize(), alignment = Alignment.Center) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Table(state.board!!)
                    Button(onClick = solve) {
                        Text(
                            "Solve",
                            style = TextStyle(color = White)
                        )
                    }
                }
            }
        }
        State.Solve -> {
            Box(modifier = Modifier.fillMaxSize(), alignment = Alignment.Center) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Table(state.board!!)
                    Button(onClick = quit) {
                        Text(
                            "Quit",
                            style = TextStyle(color = White)
                        )
                    }
                }
            }
        }
    }
}