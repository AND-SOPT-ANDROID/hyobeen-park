package org.sopt.and.domain.usecase

import org.sopt.and.domain.entitiy.auth.SignInResponseModel
import org.sopt.and.domain.repository.AuthRepository
import javax.inject.Inject

class PostSignInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        username: String,
        password: String,
    ): Result<SignInResponseModel> =
        authRepository.postSignIn(
            username = username,
            password = password,
        )
}