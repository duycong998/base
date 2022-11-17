package nexlsoft.loginsample.repository.remote

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse
import retrofit2.Response

class RemoteImpl ( private val apiService: ApiService ) : RemoteSource {
    override suspend fun getListCategories(): Response<Categories> {
        return apiService.getListCategories()
    }

    override suspend fun login(user : User): UserResponse {
        try {
            Log.d("###","apiService.login(user):"+apiService.login(user))
        }
        catch (ex:Exception){
            Log.d("###","er:"+ex.message)
        }

        return apiService.login(user)
    }
}
