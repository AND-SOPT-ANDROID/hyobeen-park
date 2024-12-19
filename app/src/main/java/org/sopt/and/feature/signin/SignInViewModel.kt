package org.sopt.and.feature.signin

import android.content.Context
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.core.util.BaseViewModel
import org.sopt.and.domain.usecase.PostSignInUseCase
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val postSignInUseCase: PostSignInUseCase,
) : BaseViewModel<SignInContract.SignInUiState, SignInContract.SignInSideEffect, SignInContract.SignInEvent>() {
    override fun createInitialState(): SignInContract.SignInUiState =
        SignInContract.SignInUiState()

    override suspend fun handleEvent(event: SignInContract.SignInEvent) {
        when (event) {
            is SignInContract.SignInEvent.OnUsernameChanged -> {
                setState { copy(username = event.username) }
            }

            is SignInContract.SignInEvent.OnPasswordChanged -> {
                setState { copy(password = event.password) }
            }

            is SignInContract.SignInEvent.OnSignInButtonClicked -> {
                signIn()
            }

            is SignInContract.SignInEvent.OnSignUpButtonClicked -> {
                setSideEffect(SignInContract.SignInSideEffect.NavigateToSignUp)
            }
        }
    }

    private fun signIn() = viewModelScope.launch {
        with(currentState) {
            postSignInUseCase(username, password)
                .onSuccess { response ->
                    setSideEffect(SignInContract.SignInSideEffect.NavigateToHome(response.token))
                }.onFailure {
                    setSideEffect(SignInContract.SignInSideEffect.ShowToast(R.string.sign_in_failed))
                }
        }
    }
}