package org.sopt.and.domain.usecase

import org.sopt.and.domain.entitiy.auth.SignUpResponseModel
import org.sopt.and.domain.repository.AuthRepository
import javax.inject.Inject

class PostSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        username: String,
        password: String,
        hobby: String,
    ): Result<SignUpResponseModel> =
        authRepository.postSignUp(
            username = username,
            password = password,
            hobby = hobby,
        )
}