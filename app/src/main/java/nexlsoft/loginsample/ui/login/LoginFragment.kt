package nexlsoft.loginsample.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nexlsoft.loginsample.R
import nexlsoft.loginsample.databinding.FragmentCategoriesBinding
import nexlsoft.loginsample.databinding.FragmentFirstBinding
import nexlsoft.loginsample.databinding.FragmentLoginBinding
import nexlsoft.loginsample.repository.model.User
import nexlsoft.loginsample.ui.categories.CategoriesFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel by viewModel<LoginViewModel>()
    private var binding: FragmentLoginBinding? = null

    private var mView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

            mView = binding!!.root
        }
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try{
            lifecycleScope.launch {


            }
        } catch (ex: Exception){
            Log.d("###","vvv:"+ex.message)
        }

//        binding!!.edtYourPassword.setOnClickListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//                if(!isLetters(s.toString())){
//                    binding!!.levelPassword.text = "High"
//                }
//            }
//        })



        binding!!.btnSignUp.setOnClickListener {
            //viewModel.login(user = User("trung", "huynh",   binding!!.edtYourEmail.text.toString(),   binding!!.edtYourPassword.text.toString()))
            findNavController().navigate(R.id.CategoriesFragment)
        }

    }

    fun isLetters(string: String): Boolean {
        for (c in string)
        {
            Log.d("###","c:"+c)
            if (c !in 'A'..'Z' && c !in 'a'..'z') {
                Log.d("###","false")
                return false
            }
        }
        return true
    }



}
