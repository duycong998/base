package nexlsoft.loginsample.ui.categories

import nexlsoft.loginsample.base.BaseViewModel
import nexlsoft.loginsample.repository.model.Categories
import nexlsoft.loginsample.repository.remote.RemoteSource

class CategoriesViewModel(
    private val remote: RemoteSource,
) : BaseViewModel() {

    val categories: MutableList<Categories> by lazy { mutableListOf() }

    fun getListCategories() {
        if (categories.isEmpty()) {
            launchCoroutine {
                remote.getListCategories().subscribe(
                    onSuccess = {
                        categories.addAll(it)
                    },
                    onError = {

                    }
                )
            }
        }
    }
}
