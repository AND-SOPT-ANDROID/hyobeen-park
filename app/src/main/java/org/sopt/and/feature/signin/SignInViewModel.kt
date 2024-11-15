package org.sopt.and.feature.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.domain.repository.AuthRepository
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _signInState: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val signInState get() = _signInState.asStateFlow()

    private val _signInSideEffect = MutableSharedFlow<SignInSideEffect>()
    val signInSideEffect get() = _signInSideEffect.asSharedFlow()

    fun onSignUpButtonClick() {
        viewModelScope.launch {
            _signInSideEffect.emit(SignInSideEffect.NavigateToSignUp)
        }
    }

    fun signIn() {
        viewModelScope.launch {
            authRepository.postSignIn(_signInState.value.email, _signInState.value.password)
                .onSuccess { response ->
                    updateToken(response.token)
                    _signInSideEffect.emit(SignInSideEffect.NavigateToHome)
                }.onFailure {
                    _signInSideEffect.emit(SignInSideEffect.ShowToast(R.string.sign_in_failed))
                }
        }
    }

    fun updateEmail(email: String) {
        _signInState.update {
            it.copy(
                email = email
            )
        }
    }

    fun updatePassword(password: String) {
        _signInState.update {
            it.copy(
                password = password
            )
        }
    }

    fun updateToken(token: String) {
        _signInState.update {
            it.copy(
                token = token
            )
        }
    }
}