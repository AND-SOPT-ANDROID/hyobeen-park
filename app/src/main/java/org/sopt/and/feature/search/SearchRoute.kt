package org.sopt.and.feature.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SearchRoute(
    paddingValues: PaddingValues,
    navController: NavHostController,
) {
    SearchScreen()
}

@Composable
fun SearchScreen() {
    Text("검색")
}