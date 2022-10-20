package com.github.shenziq1.navigationTemplate

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}"){
        fun passNameId(
            id: Int,
            name: String
        ): String{
            return "detail_screen/$id/$name"
        }
    }
    object Optional: Screen(route = "optional_screen?id={id}&name={name}"){
        fun passNameId(
            id: Int = 0,
            name: String = "NULL"
        ):String{
            return "optional_screen?id=$id&name=$name"
        }
    }
    object Login: Screen(route = "login_screen")
    object Signup: Screen(route = "signup_screen")
}