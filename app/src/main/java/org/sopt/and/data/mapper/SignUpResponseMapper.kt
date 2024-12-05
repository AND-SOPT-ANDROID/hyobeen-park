package org.sopt.and.data.mapper

import org.sopt.and.data.dto.response.SignUpResponse
import org.sopt.and.domain.entitiy.auth.SignUpResponseModel

fun SignUpResponse.toSignUpResponseModel(): SignUpResponseModel = SignUpResponseModel(
    userNumber = this.userNumber,
    code = this.code,
)
