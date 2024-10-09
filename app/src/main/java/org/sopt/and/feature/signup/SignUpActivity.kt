package org.sopt.and.feature.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.SocialLoginButton
import org.sopt.and.core.designsystem.component.textfield.EmailTextField
import org.sopt.and.core.designsystem.component.textfield.PasswordTextField
import org.sopt.and.core.designsystem.component.topappbar.CloseButtonTopAppBar
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme

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
                    SignUpScreen(
                        modifier = Modifier
                            .padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
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
        SignUpTitle(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    start = 20.dp,
                ),
            whiteText = stringResource(R.string.sign_up_title_email_and_password),
            greyText = stringResource(R.string.sign_up_title_only),
        )

        SignUpTitle(
            modifier = Modifier
                .padding(start = 20.dp),
            whiteText = stringResource(R.string.sign_up_title_enjoy_wavve),
            greyText = stringResource(R.string.sign_up_title_able),
        )

        EmailTextField(
            email = email,
            placeholder = stringResource(R.string.sign_up_email_hint),
            modifier = Modifier
                .padding(top = 30.dp)
                .padding(horizontal = 20.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_info_24),
                contentDescription = stringResource(R.string.img_email),
                tint = Color.Gray,
            )
            Text(
                text = stringResource(R.string.sign_up_email_description),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 3.dp, end = 10.dp),
            )
        }

        PasswordTextField(
            password = password,
            placeholder = stringResource(R.string.sign_up_password_hint),
            isVisible = isPasswordVisible,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp),
        )

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_info_24),
                contentDescription = stringResource(R.string.img_password),
                tint = Color.Gray,
            )
            Text(
                text = stringResource(R.string.sign_up_password_description),
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 3.dp, end = 10.dp),
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

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = stringResource(R.string.sign_up_button),
            fontSize = 16.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
    }
}

@Composable
private fun SignUpTitle(
    modifier: Modifier,
    whiteText: String,
    greyText: String,
) {
    Row(
        modifier = modifier,
    ) {
        Text(
            text = whiteText,
            fontSize = 20.sp,
            color = Color.White,
        )
        Text(
            text = greyText,
            fontSize = 20.sp,
            color = Color.Gray,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    ANDANDROIDTheme {
        SignUpScreen()
    }
}