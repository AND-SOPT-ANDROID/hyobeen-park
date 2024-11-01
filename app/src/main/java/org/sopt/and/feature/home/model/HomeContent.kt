package org.sopt.and.feature.home.model

import androidx.annotation.StringRes

data class HomeContent(
    @StringRes val title: Int,
    val contentList: List<String>,
)
