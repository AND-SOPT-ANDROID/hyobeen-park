package org.sopt.and.feature.my

import org.sopt.and.core.state.UiState

data class MyState(
    val hobby: UiState<String> = UiState.Loading,
)
