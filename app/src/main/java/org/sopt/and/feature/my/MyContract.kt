package org.sopt.and.feature.my

import org.sopt.and.core.util.UiEvent
import org.sopt.and.core.util.UiSideEffect
import org.sopt.and.core.util.UiState

class MyContract {
    data class MyUiState(
        val hobby: String = ""
    ) : UiState

    sealed interface MySideEffect : UiSideEffect {

    }

    sealed class MyEvent : UiEvent {

    }
}