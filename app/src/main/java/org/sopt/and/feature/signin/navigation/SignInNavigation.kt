package org.sopt.and.feature.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.feature.signin.SignInRoute

fun NavController.navigateToSignIn(
    email: String = "",
    password: String = "",
    navOptions: NavOptions? = null
) {
    navigate(
        route = SignIn(
            email = email,
            password = password,
        ),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.signInNavGraph(
    navHostController: NavHostController,
) {
    composable<SignIn> { backStackEntry ->
        val item = backStackEntry.toRoute<SignIn>()
        SignInRoute(
            email = item.email,
            password = item.password,
            navController = navHostController,
        )
    }
}

@Serializable
data class SignIn(
    val email: String,
    val password: String,
) : MainTabRoute