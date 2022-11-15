package nexlsoft.loginsample.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import nexlsoft.loginsample.R

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            val a = viewModel.login("", "")
            if (a.equals("success")) {
              // findNavController().navigate(R.id)
            } else {
                //
            }
        }
    }
}
