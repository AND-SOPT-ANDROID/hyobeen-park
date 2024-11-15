package org.sopt.and.data.datasource

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequest
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignInResponse
import org.sopt.and.data.dto.response.SignUpResponse

interface AuthDatasource {
    suspend fun postSignUp(
        request: SignUpRequest,
    ): BaseResponse<SignUpResponse>

    suspend fun postSignIn(
        request: SignInRequest,
    ): BaseResponse<SignInResponse>
}
