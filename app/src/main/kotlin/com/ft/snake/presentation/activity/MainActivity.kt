package com.ft.snake.presentation.activity

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ft.snake.domain.base.BaseActivity
import com.ft.snake.domain.navigation.Screen
import com.ft.snake.presentation.screen.AboutScreen
import com.ft.snake.presentation.screen.HighScoreScreen
import com.ft.snake.presentation.screen.MenuScreen
import com.ft.snake.presentation.screen.SettingScreen

class MainActivity : BaseActivity() {
    private lateinit var navController: NavHostController

    @Composable
    override fun Content() {
        navController = rememberNavController()
        SetupNavigation()
    }

    @Composable
    private fun SetupNavigation() {
        NavHost(navController = navController, startDestination = Screen.Menu.route) {
            composable(Screen.Menu.route) { MenuScreen(navController) }
            composable(Screen.HighScores.route) { HighScoreScreen(navController) }
            composable(Screen.Settings.route) { SettingScreen(navController) }
            composable(Screen.About.route) { AboutScreen(navController) }
        }
    }
}
