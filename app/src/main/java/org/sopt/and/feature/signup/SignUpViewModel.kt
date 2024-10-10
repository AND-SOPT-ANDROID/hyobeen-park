package org.sopt.and.feature.signup

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
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _signUpState: MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val signUpState get() = _signUpState.asStateFlow()

    private val _signUpSideEffect = MutableSharedFlow<SignUpSideEffect>()
    val signUpSideEffect get() = _signUpSideEffect.asSharedFlow()

    companion object {
        private const val PASSWORD_LENGTH_MIN = 8
        private const val PASSWORD_LENGTH_MAX = 20
        private const val PASSWORD_TYPE = 3

        const val EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        const val UPPER_CASE_REGEX = "[A-Z]"
        const val LOWER_CASE_REGEX = "[a-z]"
        const val NUMBER_REGEX = "[0-9]"
        const val SPECIAL_CHAR_REGEX = "[!@#\$%^&*(),.?\":{}|<>]"
    }

    fun onSignUpClick(email: String, password: String) {
        viewModelScope.launch {
            if (!isEmailValid(email)) {
                _signUpSideEffect.emit(SignUpSideEffect.Toast(R.string.sign_up_not_valid_email))
            } else if (!isPasswordValid(password)) {
                _signUpSideEffect.emit(SignUpSideEffect.Toast(R.string.sign_up_not_valid_password))
            } else {
                _signUpSideEffect.emit(SignUpSideEffect.NavigateToSignIn)
            }
        }

    }

    private fun isEmailValid(email: String): Boolean =
        email.matches(EMAIL_REGEX.toRegex())

    private fun isPasswordValid(password: String): Boolean {
        if (password.length in PASSWORD_LENGTH_MIN..PASSWORD_LENGTH_MAX) {
            var count = 0
            if (password.contains(UPPER_CASE_REGEX.toRegex())) count++
            if (password.contains(LOWER_CASE_REGEX.toRegex())) count++
            if (password.contains(NUMBER_REGEX.toRegex())) count++
            if (password.contains(SPECIAL_CHAR_REGEX.toRegex())) count++

            if (count >= PASSWORD_TYPE) return true
        }
        return false
    }

    fun updateEmail(email: String) {
        _signUpState.update {
            it.copy(
                email = email
            )
        }
    }

    fun updatePassword(password: String) {
        _signUpState.update {
            it.copy(
                password = password
            )
        }
    }

}