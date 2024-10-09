package org.sopt.and.feature.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.SocialLoginButton
import org.sopt.and.core.designsystem.component.textfield.EmailTextField
import org.sopt.and.core.designsystem.component.textfield.PasswordTextField
import org.sopt.and.core.designsystem.component.topappbar.BackButtonTopAppBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.feature.signup.SignUpActivity

class SignInActivity : ComponentActivity() {
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
                    SignInScreen(
                        navigateToSignUp = {
                            Intent(this, SignUpActivity::class.java).apply {
                                startActivity(this)
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

@Composable
fun SignInScreen(
    navigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isPasswordVisible = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        EmailTextField(
            email = email,
            placeholder = stringResource(R.string.sign_in_email),
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(horizontal = 20.dp),
        )
        PasswordTextField(
            password = password,
            placeholder = stringResource(R.string.sign_in_password),
            isVisible = isPasswordVisible,
            modifier = Modifier
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
        )

        Button(
            onClick = {},
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
            )
        ) {
            Text(
                text = stringResource(R.string.sign_in),
                color = Color.White,
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
        ) {
            Text(
                text = stringResource(R.string.sign_in_find_id),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
            Box(
                modifier = Modifier
                    .size(width = 1.dp, height = 10.dp)
                    .background(Color.Gray)
            )
            Text(
                text = stringResource(R.string.sign_in_change_password),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
            Box(
                modifier = Modifier
                    .size(width = 1.dp, height = 10.dp)
                    .background(Color.Gray)
            )
            Text(
                text = stringResource(R.string.sign_up_main_title),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        navigateToSignUp()
                    },
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 50.dp),
        ) {
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .weight(1f)
                    .background(Color.DarkGray),
            )
            Text(
                text = stringResource(R.string.sign_up_social_description),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(horizontal = 10.dp),
            )
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .weight(1f)
                    .background(Color.DarkGray),
            )
        }

        SocialLoginButton(
            modifier = Modifier
                .padding(top = 20.dp)
        )

        Text(
            text = stringResource(R.string.sign_up_information),
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(
                    top = 40.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    ANDANDROIDTheme {
        SignInScreen(
            navigateToSignUp = { },
        )
    }
}