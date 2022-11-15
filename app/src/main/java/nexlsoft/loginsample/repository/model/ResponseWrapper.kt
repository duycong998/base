package nexlsoft.loginsample.repository.model

sealed class ResponseWrapper<out T> {
    object Loading : ResponseWrapper<Nothing>()
    data class Success<out T>(val value: T) : ResponseWrapper<T>()
    data class SuccessEmpty(val value: Any = Any()) : ResponseWrapper<Nothing>()
    data class GenericError(val code: Int = -1, val error: ErrorResponse? = null) : ResponseWrapper<Nothing>()
    data class NetworkError(val code: Int = 511) : ResponseWrapper<Nothing>()
}

data class ErrorResponse(
    val code: Int,
    val message: String
)