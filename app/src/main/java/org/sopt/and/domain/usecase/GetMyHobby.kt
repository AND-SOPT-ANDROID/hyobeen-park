package org.sopt.and.domain.usecase

import org.sopt.and.domain.entitiy.my.HobbyModel
import org.sopt.and.domain.repository.MyRepository
import javax.inject.Inject

class GetMyHobby @Inject constructor(
    private val myRepository: MyRepository,
) {
    suspend operator fun invoke(
        token: String,
    ): Result<HobbyModel> =
        myRepository.getMyHobby(token)
}