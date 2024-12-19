package org.sopt.and.feature.signup

import androidx.annotation.StringRes
import org.sopt.and.core.util.UiEvent
import org.sopt.and.core.util.UiSideEffect
import org.sopt.and.core.util.UiState

class SignUpContract {
    data class SignUpUiState(
        val username: String = "",
        val password: String = "",
        val hobby: String = "",
        val isSignUpEnabled: Boolean = false,
    ) : UiState

    sealed interface SignUpSideEffect : UiSideEffect {
        data class ShowToast(@StringRes val message: Int) : SignUpSideEffect
        data object NavigateToSignIn : SignUpSideEffect
        data object NavigateUp : SignUpSideEffect
    }

    sealed class SignUpEvent : UiEvent {
        data class OnUsernameChanged(val username: String) : SignUpEvent()
        data class OnPasswordChanged(val password: String) : SignUpEvent()
        data class OnHobbyChanged(val hobby: String) : SignUpEvent()
        data object OnSignUpButtonClicked : SignUpEvent()
        data object OnBackButtonClicked : SignUpEvent()
    }
}
