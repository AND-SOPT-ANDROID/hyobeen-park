package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.MyDatasource
import org.sopt.and.data.mapper.toHobbyModel
import org.sopt.and.domain.entitiy.my.HobbyModel
import org.sopt.and.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val myDatasource: MyDatasource,
) : MyRepository {
    override suspend fun getMyHobby(token: String): Result<HobbyModel> =
        runCatching {
            myDatasource.getMyHobby(token).result.toHobbyModel()
        }
}