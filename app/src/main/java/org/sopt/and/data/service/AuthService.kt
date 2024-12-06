package org.sopt.and.data.service

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequest
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignInResponse
import org.sopt.and.data.dto.response.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("user")
    suspend fun postSignUp(
        @Body body: SignUpRequest,
    ): BaseResponse<SignUpResponse>

    @POST("login")
    suspend fun postSignIn(
        @Body body: SignInRequest,
    ): BaseResponse<SignInResponse>
}