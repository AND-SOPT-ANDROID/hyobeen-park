package org.sopt.and.feature.my

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.sopt.and.core.state.UiState
import org.sopt.and.domain.usecase.GetMyHobbyUseCase
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val getMyHobbyUseCase: GetMyHobbyUseCase,
) : ViewModel() {
    var myState: MutableStateFlow<MyState> = MutableStateFlow(MyState())
        private set

    fun getHobby(sharedPreferences: SharedPreferences) {
        val token = sharedPreferences.getString("token", null) ?: ""

        viewModelScope.launch {
            getMyHobbyUseCase(token)
                .onSuccess { response ->
                    myState.value = myState.value.copy(
                        hobby = UiState.Success(response.hobby)
                    )
                }
        }
    }
}