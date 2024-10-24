package org.sopt.and.feature.signin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.feature.signin.navigation.SignIn
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _signInState: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val signInState get() = _signInState.asStateFlow()

    private val _signInSideEffect = MutableSharedFlow<SignInSideEffect>()
    val signInSideEffect get() = _signInSideEffect.asSharedFlow()

    private val userEmail = savedStateHandle.toRoute<SignIn>().email
    private val userPassword = savedStateHandle.toRoute<SignIn>().password

    fun onLoginButtonClick() {
        viewModelScope.launch {
            with(_signInState.value) {
                if (isSignInAvailable(email, password)) {
                    _signInSideEffect.emit(SignInSideEffect.NavigateToMyPage)
                } else {
                    _signInSideEffect.emit(
                        SignInSideEffect.ShowToast(
                            R.string.sign_in_failed
                        )
                    )
                }
            }
        }
    }

    fun onSignUpButtonClick() {
        viewModelScope.launch {
            _signInSideEffect.emit(SignInSideEffect.NavigateToSignUp)
        }
    }

    private fun isSignInAvailable(email: String, password: String): Boolean {
        val isEmailValid = userEmail.isNotBlank() && email == userEmail
        val isPasswordValid = userPassword.isNotBlank() && password == userPassword
        return isEmailValid && isPasswordValid
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
}