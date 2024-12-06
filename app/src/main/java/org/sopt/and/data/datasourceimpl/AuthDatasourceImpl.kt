package org.sopt.and.data.datasourceimpl

import org.sopt.and.data.datasource.AuthDatasource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequest
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignInResponse
import org.sopt.and.data.dto.response.SignUpResponse
import org.sopt.and.data.service.AuthService
import javax.inject.Inject

class AuthDatasourceImpl @Inject constructor(
    private val authService: AuthService,
) : AuthDatasource {
    override suspend fun postSignUp(
        signUpRequest: SignUpRequest
    ): BaseResponse<SignUpResponse> = authService.postSignUp(signUpRequest)

    override suspend fun postSignIn(
        signInRequest: SignInRequest
    ): BaseResponse<SignInResponse> = authService.postSignIn(signInRequest)
}