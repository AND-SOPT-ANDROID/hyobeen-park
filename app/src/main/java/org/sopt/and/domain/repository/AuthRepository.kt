package org.sopt.and.domain.repository

import org.sopt.and.domain.entitiy.auth.SignInResponseModel
import org.sopt.and.domain.entitiy.auth.SignUpResponseModel

interface AuthRepository {
    suspend fun postSignUp(
        username: String,
        password: String,
        hobby: String,
    ): Result<SignUpResponseModel>

    suspend fun postSignIn(
        username: String,
        password: String,
    ): Result<SignInResponseModel>
}