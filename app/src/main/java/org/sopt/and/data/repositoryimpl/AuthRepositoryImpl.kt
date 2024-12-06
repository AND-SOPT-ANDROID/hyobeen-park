package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.AuthDatasource
import org.sopt.and.data.mapper.toSignInRequestDto
import org.sopt.and.data.mapper.toSignInResponseModel
import org.sopt.and.data.mapper.toSignUpRequestDto
import org.sopt.and.data.mapper.toSignUpResponseModel
import org.sopt.and.domain.entitiy.auth.SignInRequestModel
import org.sopt.and.domain.entitiy.auth.SignInResponseModel
import org.sopt.and.domain.entitiy.auth.SignUpRequestModel
import org.sopt.and.domain.entitiy.auth.SignUpResponseModel
import org.sopt.and.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDatasource: AuthDatasource
) : AuthRepository {
    override suspend fun postSignUp(
        username: String,
        password: String,
        hobby: String
    ): Result<SignUpResponseModel> =
        runCatching {
            authDatasource.postSignUp(
                SignUpRequestModel(
                    username = username,
                    password = password,
                    hobby = hobby,
                ).toSignUpRequestDto()
            ).result.toSignUpResponseModel()
        }

    override suspend fun postSignIn(
        username: String,
        password: String
    ): Result<SignInResponseModel> =
        runCatching {
            authDatasource.postSignIn(
                SignInRequestModel(
                    username = username,
                    password = password,
                ).toSignInRequestDto()
            ).result.toSignInResponseModel()
        }
}