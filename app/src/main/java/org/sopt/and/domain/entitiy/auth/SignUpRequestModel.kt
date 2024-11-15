package org.sopt.and.domain.entitiy.auth

data class SignUpRequestModel(
    val username: String,
    val password: String,
    val hobby: String,
)
