package io.github.found_cake.todolist

import kotlinx.browser.document
import react.create
import react.dom.client.createRoot

fun main() {
	val container = document.createElement("div")
	container.id = "root"
	document.body!!.appendChild(container)

	createRoot(container).render(App.create())
}