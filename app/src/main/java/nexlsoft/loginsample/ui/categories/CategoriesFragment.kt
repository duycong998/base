package nexlsoft.loginsample.ui.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nexlsoft.loginsample.R
import nexlsoft.loginsample.databinding.FragmentCategoriesBinding
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.model.Category
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoriesFragment : Fragment(R.layout.fragment_categories) {
    //  private val viewModel: CategoriesViewModel by sharedViewModel()

    private val viewModel by viewModel<CategoriesViewModel>()
    private var binding: FragmentCategoriesBinding? = null
    private val categoryAdapter by lazy { CategoryAdapter() }
    private var categories: Categories? = null
    private var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mView == null) {
            binding = FragmentCategoriesBinding.inflate(layoutInflater, container, false)

            mView = binding!!.root
        }
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.getListCategories()
        viewModel.liveData.observe(viewLifecycleOwner) {
            categories = it
            Log.d("####", it.categories.toString())
            categoryAdapter.updateNote(it.categories as MutableList<Category>)
        }
        Log.d("###", "vvvvvv" + categories?.categories.toString())

        //create
    }

    private fun initView() {
        binding!!.recyclerViewCategory.apply {
            layoutManager = GridLayoutManager(requireContext(), 3 )
            adapter = categoryAdapter
        }
    }



}
