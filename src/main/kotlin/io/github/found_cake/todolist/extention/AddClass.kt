package io.github.found_cake.todolist.extention

import react.PropsWithClassName
import web.cssom.ClassName

fun PropsWithClassName.addClass(name: String) {
	className = ClassName("$className $name")
}