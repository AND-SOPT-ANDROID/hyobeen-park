package org.sopt.and.domain.repository

import org.sopt.and.domain.entitiy.my.HobbyModel

interface MyRepository {
    suspend fun getMyHobby(
        token: String,
    ): Result<HobbyModel>
}