package org.sopt.and.feature.signup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.Route
import org.sopt.and.feature.signin.navigation.navigateToSignIn
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
        val navOptions = navOptions {
            popUpTo(navHostController.graph.id) {
                inclusive = true
            }
        }

        SignUpRoute(
            navigateToSignIn = { email, password ->
                navHostController.navigateToSignIn(
                    email = email,
                    password = password,
                    navOptions = navOptions,
                )
            },
            popStackBack = { navHostController.popBackStack() }
        )
    }
}

@Serializable
data object SignUp : Route