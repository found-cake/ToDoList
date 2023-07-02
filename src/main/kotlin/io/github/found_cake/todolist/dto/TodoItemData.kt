package io.github.found_cake.todolist.dto

data class TodoItemData(
	val id: Int,
	val text: String,
	var isCheck: Boolean = false
)
