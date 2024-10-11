package org.sopt.and.feature.signup

import androidx.annotation.StringRes

sealed class SignUpSideEffect {
    data class Toast(@StringRes val message: Int) : SignUpSideEffect()
    data object NavigateToSignIn : SignUpSideEffect()
}