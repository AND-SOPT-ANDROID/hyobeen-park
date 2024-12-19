package org.sopt.and.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.preference.PreferenceImpl

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigator: MainNavigator = rememberMainNavigator()
            ANDANDROIDTheme {
                CompositionLocalProvider(
                    PreferenceImpl.LocalPreference provides PreferenceImpl(this)
                ) {
                    MainScreen(navigator)
                }
            }
        }
    }
}
