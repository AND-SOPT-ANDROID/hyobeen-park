package org.sopt.and.feature.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.feature.signup.SignUpRoute

fun NavController.navigateToSignUp(navOptions: NavOptions? = null) {
    navigate(
        route = SignUp,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signUpNavGraph(
    navHostController: NavHostController,
) {
    composable<SignUp> {
        SignUpRoute(
            navController = navHostController,
        )
    }
}

@Serializable
data object SignUp : MainTabRoute