package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.AuthDatasource
import org.sopt.and.data.mapper.toSignUpRequestDto
import org.sopt.and.data.mapper.toSignUpResponseModel
import org.sopt.and.domain.entitiy.signup.SignUpRequestModel
import org.sopt.and.domain.entitiy.signup.SignUpResponseModel
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
        kotlin.runCatching {
            authDatasource.postSignUp(
                SignUpRequestModel(
                    username = username,
                    password = password,
                    hobby = hobby,
                ).toSignUpRequestDto()
            ).result.toSignUpResponseModel()
        }
}