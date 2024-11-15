package org.sopt.and.domain.repository

import org.sopt.and.domain.entitiy.signup.SignUpResponseModel

interface AuthRepository {
    suspend fun postSignUp(
        username: String,
        password: String,
        hobby: String,
    ): Result<SignUpResponseModel>
}