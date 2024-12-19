package org.sopt.and.feature.my

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.and.core.util.BaseViewModel
import org.sopt.and.domain.usecase.GetMyHobbyUseCase
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val getMyHobbyUseCase: GetMyHobbyUseCase,
) : BaseViewModel<MyContract.MyUiState, MyContract.MySideEffect, MyContract.MyEvent>() {
    override fun createInitialState(): MyContract.MyUiState =
        MyContract.MyUiState()

    override suspend fun handleEvent(event: MyContract.MyEvent) {

    }

    fun getHobby(token: String) {
        viewModelScope.launch {
            getMyHobbyUseCase(token)
                .onSuccess { response ->
                    setState { copy(hobby = response.hobby) }
                }
        }
    }
}