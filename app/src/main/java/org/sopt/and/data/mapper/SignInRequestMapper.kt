package org.sopt.and.data.mapper

import org.sopt.and.data.dto.request.SignInRequest
import org.sopt.and.domain.entitiy.auth.SignInRequestModel

fun SignInRequestModel.toSignInRequestDto(): SignInRequest =
    SignInRequest(
        username = this.username,
        password = this.password,
    )