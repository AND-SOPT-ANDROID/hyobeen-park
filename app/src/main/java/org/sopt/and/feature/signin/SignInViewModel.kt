package org.sopt.and.feature.signin

import android.content.Context
import android.content.SharedPreferences
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
import org.sopt.and.domain.usecase.PostSignInUseCase
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val postSignInUseCase: PostSignInUseCase,
) : ViewModel() {
    private val _signInState: MutableStateFlow<SignInState> = MutableStateFlow(SignInState())
    val signInState get() = _signInState.asStateFlow()

    private val _signInSideEffect = MutableSharedFlow<SignInSideEffect>()
    val signInSideEffect get() = _signInSideEffect.asSharedFlow()

    private var sharedPreferences: SharedPreferences? = null

    fun onSignUpButtonClick() {
        viewModelScope.launch {
            _signInSideEffect.emit(SignInSideEffect.NavigateToSignUp)
        }
    }

    fun signIn() {
        viewModelScope.launch {
            postSignInUseCase(
                username = _signInState.value.email,
                password = _signInState.value.password,
            ).onSuccess { response ->
                saveToken(response.token)
                _signInSideEffect.emit(SignInSideEffect.NavigateToHome)
            }.onFailure {
                _signInSideEffect.emit(SignInSideEffect.ShowToast(R.string.sign_in_failed))
            }
        }
    }

    fun initializePreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    }

    private fun saveToken(token: String) {
        sharedPreferences?.edit()?.putString("token", token)?.apply()
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