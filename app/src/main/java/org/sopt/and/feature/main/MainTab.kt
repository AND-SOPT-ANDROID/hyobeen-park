package org.sopt.and.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.and.R
import org.sopt.and.core.navigation.MainTabRoute
import org.sopt.and.core.navigation.Route
import org.sopt.and.feature.home.navigation.Home
import org.sopt.and.feature.my.navigation.My
import org.sopt.and.feature.search.navigation.Search

enum class MainTab(
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int,
    val route: MainTabRoute
) {
    HOME(
        icon = R.drawable.ic_home_24,
        contentDescription = R.string.home,
        route = Home,
    ),
    SEARCH(
        icon = R.drawable.ic_search_24,
        contentDescription = R.string.search,
        route = Search,
    ),
    MY(
        icon = R.drawable.ic_launcher_background,
        contentDescription = R.string.my,
        route = My,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
