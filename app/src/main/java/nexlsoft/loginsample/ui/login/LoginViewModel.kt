package nexlsoft.loginsample.ui.login

import android.util.Log
import nexlsoft.loginsample.base.BaseViewModel
import nexlsoft.loginsample.data.repository.model.User
import nexlsoft.loginsample.data.repository.remote.RemoteSource

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
