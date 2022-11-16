package nexlsoft.loginsample.repository.remote

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @GET("categories")
    suspend fun getListCategories(): Categories

    @POST("auth/signup")
    suspend fun login(@Body loginRequest: User): UserResponse
}
