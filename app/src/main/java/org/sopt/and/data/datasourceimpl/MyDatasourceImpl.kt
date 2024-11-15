package org.sopt.and.data.datasourceimpl

import org.sopt.and.data.datasource.MyDatasource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.GetHobbyResponse
import org.sopt.and.data.service.MyService
import javax.inject.Inject

class MyDatasourceImpl @Inject constructor(
    private val myService: MyService
) : MyDatasource {
    override suspend fun getMyHobby(token: String): BaseResponse<GetHobbyResponse> =
        myService.getMyHobby(token)
}