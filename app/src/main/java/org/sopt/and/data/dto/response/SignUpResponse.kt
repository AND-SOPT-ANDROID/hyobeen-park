package org.sopt.and.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    @SerialName("no")
    val userNumber: Int? = null,
    @SerialName("code")
    val code: String? = null,
)
