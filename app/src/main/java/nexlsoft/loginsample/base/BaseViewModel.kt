package nexlsoft.loginsample.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import nexlsoft.loginsample.repository.model.ErrorResponse
import nexlsoft.loginsample.repository.model.ResponseWrapper

abstract class BaseViewModel : ViewModel() {

    var coroutineExceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler {
            _, exception ->
        exception.printStackTrace()
    }

    protected fun launchCoroutine(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(coroutineExceptionHandler + Dispatchers.IO) {
            block()
        }
    }



    suspend fun <T> Flow<ResponseWrapper<T>>.subscribe(
        onSuccess: ((T) -> Unit)? = null,
        onError: (() -> Unit)? = null
    ) {
        this.subscribe(onSuccess) {->
            Log.d("###","vvv:"+onError?.invoke())
            onError?.invoke()
        }
    }


}




