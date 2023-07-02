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
	val (todoMap, setTodoMap) = useState<MutableMap<Int, TodoItemData>>(mutableMapOf())

	div {
		css{
			width = 90.pct
		}

		AddTodoItem{
			addTodoItem = { text ->
				val id: Int = TodoId.nextId
				todoMap[id] = TodoItemData(id, text)
				setTodoMap(todoMap.toMutableMap())
			}
		}
		div{
			css {
				marginTop = 1.rem
			}
			addClass("container")
			todoMap.forEach {(id, todoData) ->
				TodoItem{
					item = todoData
					removeItem = {
						todoMap.remove(id)
						setTodoMap(todoMap.toMutableMap())
					}
				}
			}
		}
	}
}