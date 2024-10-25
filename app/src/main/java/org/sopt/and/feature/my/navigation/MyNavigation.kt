package org.sopt.and.feature.my.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.feature.my.MyRoute

fun NavController.navigateToMy(navOptions: NavOptions? = null) {
    navigate(
        route = My,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.myNavGraph(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
) {
    composable<My>(
        exitTransition = {
            ExitTransition.None
        },
        popEnterTransition = {
            EnterTransition.None
        },
        enterTransition = {
            EnterTransition.None
        },
        popExitTransition = {
            ExitTransition.None
        }
    ) {
        MyRoute(
            paddingValues = paddingValues,
            navController = navHostController
        )
    }
}

@Serializable
data object My : MainTabRoute