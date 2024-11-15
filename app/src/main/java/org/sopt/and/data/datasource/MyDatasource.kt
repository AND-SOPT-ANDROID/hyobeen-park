package org.sopt.and.data.datasource

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.GetHobbyResponse

interface MyDatasource {
    suspend fun getMyHobby(token: String): BaseResponse<GetHobbyResponse>
}