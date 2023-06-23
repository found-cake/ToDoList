package io.github.found_cake.todolist.utils

object TodoId{
	private var todoId = 0

	val id
		get() = todoId++
}