package nexlsoft.loginsample.repository.model

data class UserResponse(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val token: String = ""
)