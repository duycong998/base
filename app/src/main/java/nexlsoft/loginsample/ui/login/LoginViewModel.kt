package nexlsoft.loginsample.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.subscribe
import nexlsoft.loginsample.base.BaseViewModel
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse
import nexlsoft.loginsample.repository.remote.RemoteSource

class LoginViewModel( val remote: RemoteSource) : BaseViewModel() {

     fun login(user: User)  {
        Log.d("###","login:")
        try {
            launchCoroutine {
                remote.login(user).subscribe(
                    onSuccess = {
                        Log.d("###","data:"+it.token)
                    },
                    onError = {
                        Log.d("###","errr:")
                    }
                )
            }
        } catch (e : Exception) {
            Log.d("###","errr:" + e)
        }
    }
}
