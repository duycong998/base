package nexlsoft.loginsample.repository.remote

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse
import retrofit2.Response

interface RemoteSource {
    suspend fun getListCategories(): Response<Categories>

    suspend fun login(user:User) : UserResponse
}