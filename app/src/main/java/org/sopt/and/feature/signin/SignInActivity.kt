package org.sopt.and.feature.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.topappbar.BackButtonTopAppBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.extension.toast
import org.sopt.and.feature.mypage.MyPageActivity
import org.sopt.and.feature.signup.SignUpActivity

const val ID_KEY = "id"
const val PASSWORD_KEY = "password"

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {
    private var userId: String = ""
    private var userPassword: String = ""

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                userId = result.data?.getStringExtra(ID_KEY) ?: ""
                userPassword = result.data?.getStringExtra(PASSWORD_KEY) ?: ""
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutine = rememberCoroutineScope()
            val snackbarHostState = remember {
                SnackbarHostState()
            }
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
                        navigateToSignUp = {
                            val intent = Intent(this, SignUpActivity::class.java)
                            resultLauncher.launch(intent)
                        },
                        navigateToMyPage = { email, password ->
                            if (isSignInAvailable(email, password)) {
                                Intent(this, MyPageActivity::class.java).apply {
                                    putExtra(ID_KEY, email)
                                    startActivity(this)
                                    finish()
                                }
                            } else {
                                this.toast(R.string.sign_in_failed)
                                coroutine.launch {
                                    snackbarHostState.showSnackbar(
                                        message = this@SignInActivity.getString(R.string.sign_in_failed),
                                        actionLabel = this@SignInActivity.getString(R.string.sign_in_failed),
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun isSignInAvailable(email: String, password: String): Boolean {
        val isEmailValid = email.isNotBlank() && email == userId
        val isPasswordValid = password.isNotBlank() && password == userPassword
        return isEmailValid && isPasswordValid
    }
}
