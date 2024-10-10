package org.sopt.and.feature.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.topappbar.CloseButtonTopAppBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.feature.signin.ID_KEY
import org.sopt.and.feature.signin.PASSWORD_KEY
import org.sopt.and.feature.signin.SignInActivity

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ANDANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CloseButtonTopAppBar(
                            title = stringResource(R.string.sign_up_main_title),
                            onCloseClick = {},
                        )
                    }
                ) { innerPadding ->
                    SignUpRoute(
                        navigateToSignIn = { email, password ->
                            Intent(this, SignInActivity::class.java).apply {
                                putExtra(ID_KEY, email)
                                putExtra(PASSWORD_KEY, password)
                                setResult(RESULT_OK)
                                finish()
                            }
                        },
                        modifier = Modifier
                            .padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}
