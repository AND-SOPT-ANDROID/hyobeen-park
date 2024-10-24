package org.sopt.and.feature.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.and.feature.home.navigation.homeNavGraph
import org.sopt.and.feature.my.navigation.myNavGraph
import org.sopt.and.feature.search.navigation.searchNavGraph
import org.sopt.and.feature.signin.navigation.signInNavGraph
import org.sopt.and.feature.signup.navigation.signUpNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator,
) {
    Scaffold(

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            NavHost(
                enterTransition = {
                    EnterTransition.None
                },
                exitTransition = {
                    ExitTransition.None
                },
                popEnterTransition = {
                    EnterTransition.None
                },
                popExitTransition = {
                    ExitTransition.None
                },
                navController = navigator.navController,
                startDestination = navigator.startDestination
            ) {
                homeNavGraph(
                    paddingValues = paddingValues,
                    navHostController = navigator.navController,
                )
                searchNavGraph(
                    paddingValues = paddingValues,
                    navHostController = navigator.navController,
                )
                myNavGraph(
                    paddingValues = paddingValues,
                    navHostController = navigator.navController,
                )

                signInNavGraph(
                    navHostController = navigator.navController,
                )
                signUpNavGraph(
                    navHostController = navigator.navController,
                )
            }
        }
    }
}
