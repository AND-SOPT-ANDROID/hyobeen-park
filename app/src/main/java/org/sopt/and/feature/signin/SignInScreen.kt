package org.sopt.and.feature.signin

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.flowWithLifecycle
import org.sopt.and.R
import org.sopt.and.core.designsystem.component.SocialLoginButton
import org.sopt.and.core.designsystem.component.textfield.EmailTextField
import org.sopt.and.core.designsystem.component.textfield.PasswordTextField
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.core.extension.toast

@Composable
fun SignInRoute(
    navigateToSignUp: () -> Unit,
    navigateToMyPage: (String, String) -> Unit,
    viewModel: SignInViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    val signInState by viewModel.signInState.collectAsState()

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.signInSideEffect, lifecycleOwner) {
        viewModel.signInSideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SignInSideEffect.ShowToast -> {
                        context.toast(sideEffect.message)
                    }

                    is SignInSideEffect.ShowSnackBar -> {}
                    is SignInSideEffect.NavigateToSignUp -> navigateToSignUp()
                    is SignInSideEffect.NavigateToMyPage -> {
                        navigateToMyPage(signInState.email, signInState.password)
                    }
                }
            }
    }

    SignInScreen(
        onSignUpButtonClick = viewModel::onSignUpButtonClick,
        onSignInButtonClick = viewModel::onLoginButtonClick,
        onIdChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        modifier = modifier,
    )
}

@Composable
fun SignInScreen(
    onSignInButtonClick: (String, String) -> Unit,
    onSignUpButtonClick: () -> Unit,
    onIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
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
            onValueChange = onIdChange,
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(horizontal = 20.dp),
        )
        PasswordTextField(
            password = password,
            placeholder = stringResource(R.string.sign_in_password),
            isVisible = isPasswordVisible,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .padding(top = 5.dp)
                .padding(horizontal = 20.dp),
        )

        Button(
            onClick = {
                onSignInButtonClick(email.value, password.value)
            },
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
                        onSignUpButtonClick()
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
            onSignUpButtonClick = { },
            onSignInButtonClick = {_, _-> },
            onIdChange = { },
            onPasswordChange = { },
            modifier = Modifier,
        )
    }
}