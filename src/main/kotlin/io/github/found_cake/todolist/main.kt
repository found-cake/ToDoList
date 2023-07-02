package io.github.found_cake.todolist

import kotlinx.browser.document
import react.create
import react.dom.client.createRoot
import web.dom.Element

fun main() {
	val container = document.createElement("div").also {
		it.id = "root"
		document.body!!.appendChild(it)
	}

	createRoot(container.unsafeCast<Element>()).render(App.create())
}