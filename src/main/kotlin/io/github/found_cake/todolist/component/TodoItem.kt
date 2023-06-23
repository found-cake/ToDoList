package io.github.found_cake.todolist.component

import csstype.*
import emotion.react.css
import io.github.found_cake.todolist.dto.TodoItemData
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.useEffect
import react.useState

external interface TodoItemProps: Props{
	var item: TodoItemData
}

val TodoItem = FC<TodoItemProps> {props ->
	var isCheck by useState(props.item.isCheck)
	useEffect {
		props.item.isCheck = isCheck
	}
	div {
		input {
			type = InputType.checkbox
			checked = isCheck
			onClick = {isCheck = !isCheck}
			css {
				marginRight = 5.px
				float = Float.left
				width = 20.px
				height = 20.px
			}
		}
		label {
			+ props.item.text
			css {
				fontSize = 25.px
				textDecoration = if(isCheck) TextDecoration.lineThrough else null
				fontStyle = if(isCheck) FontStyle.italic else null
			}
		}
	}
}