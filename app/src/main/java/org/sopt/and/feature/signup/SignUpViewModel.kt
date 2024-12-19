package org.sopt.and.feature.signup

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.core.util.BaseViewModel
import org.sopt.and.domain.usecase.PostSignUpUseCase
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val postSignUpUseCase: PostSignUpUseCase,
) : BaseViewModel<SignUpContract.SignUpUiState, SignUpContract.SignUpSideEffect, SignUpContract.SignUpEvent>() {
    override fun createInitialState(): SignUpContract.SignUpUiState =
        SignUpContract.SignUpUiState()

    override suspend fun handleEvent(event: SignUpContract.SignUpEvent) {
        when (event) {
            is SignUpContract.SignUpEvent.OnUsernameChanged -> {
                val isSignUpEnabled = isSignUpAvailable()
                setState { copy(username = event.username, isSignUpEnabled = isSignUpEnabled) }
            }

            is SignUpContract.SignUpEvent.OnPasswordChanged -> {
                val isSignUpEnabled = isSignUpAvailable()
                setState { copy(password = event.password, isSignUpEnabled = isSignUpEnabled) }
            }

            is SignUpContract.SignUpEvent.OnHobbyChanged -> {
                val isSignUpEnabled = isSignUpAvailable()
                setState { copy(hobby = event.hobby, isSignUpEnabled = isSignUpEnabled) }
            }

            is SignUpContract.SignUpEvent.OnBackButtonClicked -> {
                setSideEffect(sideEffect = SignUpContract.SignUpSideEffect.NavigateUp)
            }

            is SignUpContract.SignUpEvent.OnSignUpButtonClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() = viewModelScope.launch {
        with(currentState) {
            if (isSignUpEnabled) {
                postSignUpUseCase(username, password, hobby)
                    .onSuccess {
                        setSideEffect(SignUpContract.SignUpSideEffect.ShowToast(R.string.sign_up_success))
                        setSideEffect(SignUpContract.SignUpSideEffect.NavigateToSignIn)
                    }.onFailure {
                        setSideEffect(SignUpContract.SignUpSideEffect.ShowToast(R.string.sign_up_failed))
                    }
            }
        }
    }

    private fun isSignUpAvailable(): Boolean =
        with(currentState) {
            username.length in MIN_LENGTH..MAX_LENGTH
                    && password.length in MIN_LENGTH..MAX_LENGTH
                    && hobby.length in MIN_LENGTH..MAX_LENGTH
        }

    companion object {
        private const val MAX_LENGTH = 8
        private const val MIN_LENGTH = 1
    }
}