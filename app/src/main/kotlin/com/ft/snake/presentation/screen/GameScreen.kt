package com.ft.snake.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.ft.snake.R
import com.ft.snake.domain.game.GameEngine
import com.ft.snake.domain.game.SnakeDirection
import com.ft.snake.presentation.activity.GameActivity
import com.ft.snake.presentation.component.AppBar
import com.ft.snake.presentation.component.Board
import com.ft.snake.presentation.component.Controller

@Composable
fun GameScreen(gameEngine: GameEngine, score: Int) {
    val state = gameEngine.state.collectAsState(initial = null)
    val activity = LocalContext.current as GameActivity
    AppBar(
        title = stringResource(id = R.string.your_score, score),
        onBackClicked = { activity.finish() }) { contentPadding ->
        Column(
            modifier = Modifier.padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            state.value?.let { Board(it) }
            Controller {
                when (it) {
                    SnakeDirection.Up -> gameEngine.move = Pair(0, -1)
                    SnakeDirection.Left -> gameEngine.move = Pair(-1, 0)
                    SnakeDirection.Right -> gameEngine.move = Pair(1, 0)
                    SnakeDirection.Down -> gameEngine.move = Pair(0, 1)
                }
            }
        }
    }
}