package org.sopt.and.data.mapper

import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.domain.entitiy.auth.SignUpRequestModel

fun SignUpRequestModel.toSignUpRequestDto(): SignUpRequest = SignUpRequest(
    username = this.username,
    password = this.password,
    hobby = this.hobby,
)