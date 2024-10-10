package org.sopt.and.feature.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.core.designsystem.component.topappbar.BackButtonTopAppBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.feature.signup.SignUpActivity

const val ID_KEY = "id"
const val PASSWORD_KEY = "password"

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {
    private var id: String = ""
    private var password: String = ""

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                id = result.data?.getStringExtra(ID_KEY) ?: ""
                password = result.data?.getStringExtra(PASSWORD_KEY) ?: ""
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ANDANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        BackButtonTopAppBar(
                            onBackClick = {},
                        )
                    }
                ) { innerPadding ->
                    SignInRoute(
                        id,
                        password,
                        navigateToSignUp = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            resultLauncher.launch(intent)
                        },
                        navigateToMyPage = {},
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
