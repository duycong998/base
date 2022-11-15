package nexlsoft.loginsample.repository.remote

import kotlinx.coroutines.flow.Flow
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse

interface RemoteSource {
    suspend fun getListCategories(): Flow<ResponseWrapper<List<Categories>>>

    suspend fun login(user:User) : Flow<ResponseWrapper<UserResponse>>
}