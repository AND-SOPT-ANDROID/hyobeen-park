package org.sopt.and.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Text("홈")
}