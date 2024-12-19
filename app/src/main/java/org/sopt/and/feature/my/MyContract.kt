package org.sopt.and.feature.my

import org.sopt.and.core.util.UiState

class MyContract {
    data class MyUiState(
        val hobby: String = ""
    ) : UiState
}