package nexlsoft.loginsample.ui.login

import nexlsoft.loginsample.base.BaseViewModel
import nexlsoft.loginsample.repository.remote.RemoteSource

class LoginViewModel(private val remote: RemoteSource) : BaseViewModel() {

    suspend fun login(email: String, password: String) : String {
        val a = remote.login(email, password)
        a.subscribe {
            
        }
        return if (remote.login(email, password).) {
            "success"
        } else {
            "fail"
        }
    }
}
