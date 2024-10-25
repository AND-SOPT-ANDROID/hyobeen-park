package org.sopt.and.feature.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val homeState get() = _homeState.asStateFlow()
}
