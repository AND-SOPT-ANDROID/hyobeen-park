package org.sopt.and.data.mapper

import org.sopt.and.data.dto.response.SignInResponse
import org.sopt.and.domain.entitiy.auth.SignInResponseModel

fun SignInResponse.toSignInResponseModel(): SignInResponseModel =
    SignInResponseModel(
        token = this.token
    )