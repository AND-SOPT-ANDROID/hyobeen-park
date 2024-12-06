package org.sopt.and.data.service

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.GetHobbyResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface MyService {
    @GET("user/my-hobby")
    suspend fun getMyHobby(
        @Header("token") token: String,
    ): BaseResponse<GetHobbyResponse>
}