package org.sopt.and.feature.signin

import androidx.annotation.StringRes

sealed class SignInSideEffect {
    data class ShowToast(@StringRes val message: Int) : SignInSideEffect()
    data class ShowSnackBar(@StringRes val message: Int) : SignInSideEffect()
    data object NavigateToSignUp : SignInSideEffect()
    data object NavigateToHome : SignInSideEffect()
}
