package nexlsoft.loginsample.common

import androidx.annotation.IdRes
import nexlsoft.loginsample.R


sealed class RouteSection(val graph: Int) {
    object Home : RouteSection(R.navigation.nav_graph)
}

sealed class RouteDestination(@IdRes val destination: Int) {

    object Back : RouteDestination(-1)

   /* sealed class Starter(@IdRes destination: Int) : RouteDestination(destination) {
        object Language : Starter(R.id.languageFragment2)
    }*/

    sealed class Home(@IdRes destination: Int) : RouteDestination(destination) {
        object Login : Home(R.id.LoginFragment)
        object Categories : Home(R.id.CategoriesFragment)

    }
}