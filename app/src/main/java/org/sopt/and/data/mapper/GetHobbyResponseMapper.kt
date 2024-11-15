package org.sopt.and.data.mapper

import org.sopt.and.data.dto.response.GetHobbyResponse
import org.sopt.and.domain.entitiy.my.HobbyModel

fun GetHobbyResponse.toHobbyModel(): HobbyModel =
    HobbyModel(
        hobby = this.hobby
    )