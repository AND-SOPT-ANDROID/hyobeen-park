package org.sopt.and.data.dto.response.SignInRes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    @SerialName("token")
    val token: String,
)
