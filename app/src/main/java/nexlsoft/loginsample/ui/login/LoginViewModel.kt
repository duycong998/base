package nexlsoft.loginsample.ui.login

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.subscribe
import nexlsoft.loginsample.base.BaseViewModel
import nexlsoft.loginsample.common.RouteDestination
import nexlsoft.loginsample.repository.model.ResponseWrapper
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.repository.model.UserResponse
import nexlsoft.loginsample.repository.remote.RemoteSource

class LoginViewModel( val remote: RemoteSource) : BaseViewModel() {

     fun login(user: User)  {
        try {
           /* kotlin.runCatching {
                launchCoroutine {

                }.
            }*/
            launchCoroutine {
                remote.login(user)
                try{
                    Log.d("###","login:")
                } catch (ex:Exception){
                    Log.d("###","ex:"+ex.message)
                }

            }
        } catch (e : Exception) {
            Log.d("###","errr:" + e)
        }
    }





}
