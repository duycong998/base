package nexlsoft.loginsample.ui.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import nexlsoft.loginsample.base.BaseViewModel
import nexlsoft.loginsample.data.local.AppSharedPreferences
import nexlsoft.loginsample.data.repository.model.Categories
import nexlsoft.loginsample.data.repository.model.User
import nexlsoft.loginsample.data.repository.model.UserResponse
import nexlsoft.loginsample.data.repository.remote.RemoteSource
import retrofit2.Response

class LoginViewModel( val remote: RemoteSource) : BaseViewModel() {
     //var token = MutableLiveData<String>()
    var token: String? = null
    private var response : Response<UserResponse>? = null
     fun login(user: User, context: Context)  {
        try {
           /* kotlin.runCatching {
                launchCoroutine {

                }.
            }*/

            launchCoroutine {
                response = remote.login(user)
                if(response!!.isSuccessful){
                    AppSharedPreferences(context).saveToken(response!!.body()!!.token)
                }else{
                    Log.d("###","fail")
                }


            }
        } catch (e : Exception) {
            Log.d("###","errr:" + e)
        }
    }





}
