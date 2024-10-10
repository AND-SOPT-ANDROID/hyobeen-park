package org.sopt.and.feature.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {
    private val _signInState: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val signInState get() = _signInState.asStateFlow()

    private val _signInSideEffect = MutableSharedFlow<SignInSideEffect>()
    val signInSideEffect get() = _signInSideEffect.asSharedFlow()

    fun onLoginButtonClick(email: String, password: String) {
        viewModelScope.launch {
            Log.d("test", _signInState.value.email)
            if (email.isNotBlank() && password.isNotBlank() && email == _signInState.value.email && password == _signInState.value.password) {
                Log.d("test", _signInState.value.email)
                _signInSideEffect.emit(SignInSideEffect.NavigateToMyPage)
            } else {
                _signInSideEffect.emit(SignInSideEffect.ShowSnackBar("아이디와 비밀번호를 확인해주세요."))
            }
        }
    }

    fun onSignUpButtonClick() {
        viewModelScope.launch {
            _signInSideEffect.emit(SignInSideEffect.NavigateToSignUp)
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
}