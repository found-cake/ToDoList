package io.github.found_cake.todolist.component

import emotion.react.css
import io.github.found_cake.todolist.dto.TodoItemData
import io.github.found_cake.todolist.extention.addClass
import io.github.found_cake.todolist.utils.TodoId
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.useState
import web.cssom.pct
import web.cssom.rem

val TodoList = FC<Props> {
	val (todoList, setTodoList) = useState<MutableList<TodoItemData>>(mutableListOf())

	div {
		css{
			width = 90.pct
		}

		AddTodoItem{
			addTodoItem = { text ->
				todoList.add(TodoItemData(TodoId.id, text))
				setTodoList(todoList.toMutableList())
			}
		}
		div{
			css {
				marginTop = 1.rem
			}
			addClass("container")
			todoList.forEach {
				TodoItem{
					item = it
				}
			}
		}
	}
}