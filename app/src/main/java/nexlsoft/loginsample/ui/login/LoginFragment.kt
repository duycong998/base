package nexlsoft.loginsample.ui.login

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import nexlsoft.loginsample.R
import nexlsoft.loginsample.data.local.AppSharedPreferences
import nexlsoft.loginsample.data.repository.model.User
import nexlsoft.loginsample.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login), SharedPreferences.OnSharedPreferenceChangeListener {
    private val viewModel by viewModel<LoginViewModel>()
    private var binding: FragmentLoginBinding? = null

    private var mView: View? = null

    override fun onStart() {
        super.onStart()
        AppSharedPreferences(requireContext()).registerOnChange(this)
    }

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
            viewModel.login(user = User("trung", "huynh",   binding!!.edtYourEmail.text.toString(),   binding!!.edtYourPassword.text.toString()))
         //   findNavController().navigate(R.id.CategoriesFragment)
            val text = binding!!.edtYourPassword.text.toString()
            AppSharedPreferences(requireContext()).saveToken(text)
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

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {
        val text =  AppSharedPreferences(requireContext()).loadToken()
        binding!!.textView.text = text
    }

    override fun onDestroy() {
        super.onDestroy()
        AppSharedPreferences(requireContext()).unregisterOnChange(this)
    }
}
