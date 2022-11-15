package nexlsoft.loginsample.ui.categories

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import nexlsoft.loginsample.R
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CategoriesFragment() : Fragment(R.layout.content_main) {
    private val viewModel: CategoriesViewModel by sharedViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val a =  viewModel.categories
        Log.d("###", a.toString())

        //create
    }
}
