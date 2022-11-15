package nexlsoft.loginsample.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nexlsoft.loginsample.R
import nexlsoft.loginsample.repository.model.User
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel by viewModel<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try{
            lifecycleScope.launch {

                viewModel.login(user = User("trung", "huynh","test124355@gmail.com","1234567"))

            }
        } catch (ex: Exception){
            Log.d("###","vvv:"+ex.message)
        }

    }
}
