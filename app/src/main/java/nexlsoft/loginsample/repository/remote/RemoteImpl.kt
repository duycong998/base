package nexlsoft.loginsample.repository.remote

import kotlinx.coroutines.flow.Flow
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse

class RemoteImpl constructor( private val apiService: ApiService ) : RemoteSource {
    override suspend fun getListCategories(): Flow<ResponseWrapper<List<Categories>>> {
        return apiService.getListCategories()
    }

    override suspend fun login(user : User): Flow<ResponseWrapper<UserResponse>> {
        return apiService.login(user)
    }
}
