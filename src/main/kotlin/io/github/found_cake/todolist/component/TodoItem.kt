package io.github.found_cake.todolist.component

import emotion.react.css
import io.github.found_cake.todolist.dto.TodoItemData
import io.github.found_cake.todolist.extention.addClass
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.svg.ReactSVG.svg
import react.dom.svg.ReactSVG.path
import react.useState
import web.cssom.*
import web.html.InputType

external interface TodoItemProps: Props{
	var item: TodoItemData
}

val TodoItem = FC<TodoItemProps> {props ->
	var isCheck by useState(props.item.isCheck)
	div {
		css{
			border = Border(3.px, LineStyle.solid, rgb(255, 133, 81))
			borderRadius = 5.px
			backgroundColor = rgb(255, 222, 222)
			margin = 2.px
			minHeight = 40.px
		}

		input {
			type = InputType.checkbox
			checked = isCheck
			onClick = {
				isCheck = !isCheck
				props.item.isCheck = !isCheck
			}
			css {
				marginTop = 10.px
				marginLeft = 5.px
				marginRight = 5.px
				float = Float.left
				width = 20.px
				height = 20.px
			}
		}
		svg {
			css {
				float = Float.right
				marginTop = 8.px
				marginLeft = 5.px
				marginRight = 5.px
			}
			xmlns = "http://www.w3.org/2000/svg"
			width = 30.0
			height = 30.0
			fill = "currentColor"
			addClass("bi bi-trash-fill")
			viewBox = "0 0 16 16"
			path {
				d =
					"M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"
			}
		}
		label {
			+ props.item.text
			css {
				fontSize = 25.px
				textDecoration = if(isCheck) TextDecoration.lineThrough else null
				fontStyle = if(isCheck) FontStyle.italic else null
			}
			addClass("mb-1")
		}
	}
}
