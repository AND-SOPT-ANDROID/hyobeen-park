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
) : BaseViewModel<MyContract.MyUiState, Nothing, Nothing>() {
    override fun createInitialState(): MyContract.MyUiState =
        MyContract.MyUiState()

    override suspend fun handleEvent(event: Nothing) {}

    fun getHobby(token: String) {
        viewModelScope.launch {
            getMyHobbyUseCase(token)
                .onSuccess { response ->
                    setState { copy(hobby = response.hobby) }
                }
        }
    }
}