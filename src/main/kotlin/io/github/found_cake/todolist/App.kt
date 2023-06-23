package io.github.found_cake.todolist

import io.github.found_cake.todolist.component.Header
import io.github.found_cake.todolist.component.TodoList
import react.FC
import react.Props
import react.dom.html.ReactHTML.style

val App = FC<Props> {
	style{
		+ "body { background-color: #FAF0E4; }"
		+ "#root { margin: 0px; padding: 0px;}"
	}
	Header{}
	TodoList{}
}