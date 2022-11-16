package nexlsoft.loginsample.repository.model

import com.google.gson.annotations.SerializedName

data class Category (
    val _id: String = "",
    val name: String = "")

class Categories {
    @SerializedName("categories")
    var categories: List<Category>? = null
}