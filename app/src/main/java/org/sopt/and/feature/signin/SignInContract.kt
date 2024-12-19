package org.sopt.and.feature.signin

import androidx.annotation.StringRes
import org.sopt.and.core.util.UiEvent
import org.sopt.and.core.util.UiSideEffect
import org.sopt.and.core.util.UiState

class SignInContract {
    data class SignInUiState(
        val username: String = "",
        val password: String = "",
    ): UiState

    sealed interface SignInSideEffect : UiSideEffect {
        data class ShowToast(@StringRes val message: Int) : SignInSideEffect
        data object NavigateToSignUp : SignInSideEffect
        data class NavigateToHome(val token: String) : SignInSideEffect
    }

    sealed class SignInEvent : UiEvent {
        data class OnUsernameChanged(val username: String) : SignInEvent()
        data class OnPasswordChanged(val password: String) : SignInEvent()
        data object OnSignInButtonClicked : SignInEvent()
        data object OnSignUpButtonClicked : SignInEvent()
    }

}
