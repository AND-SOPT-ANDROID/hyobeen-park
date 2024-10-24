package org.sopt.and.feature.signin.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import kotlinx.serialization.Serializable
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.feature.home.navigation.navigateToHome
import org.sopt.and.feature.signin.SignInRoute
import org.sopt.and.feature.signup.navigation.navigateToSignUp

fun NavController.navigateToSignIn(
    email: String = "",
    password: String = "",
    navOptions: NavOptions? = null,
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
    composable<SignIn> {
        val navOptions = navOptions {
            popUpTo(navHostController.graph.id) {
                inclusive = true
            }
        }
        SignInRoute(
            navigateToSignUp = { navHostController.navigateToSignUp() },
            navigateToHome = { navHostController.navigateToHome(navOptions = navOptions) }
        )
    }
}

@Serializable
data class SignIn(
    val email: String,
    val password: String,
) : MainTabRoute