package org.sopt.and.data.datasourceimpl

import org.sopt.and.data.datasource.AuthDatasource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignUpResponse
import org.sopt.and.data.service.AuthService
import javax.inject.Inject

class AuthDatasourceImpl @Inject constructor(
    private val authService: AuthService,
) : AuthDatasource {
    override suspend fun postSignUp(
        request: SignUpRequest
    ): BaseResponse<SignUpResponse> = authService.postSignUp(request)
}