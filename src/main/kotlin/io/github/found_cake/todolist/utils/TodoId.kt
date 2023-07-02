package io.github.found_cake.todolist.utils

object TodoId{
	private var id = 0

	val nextId
		get() = id++
}