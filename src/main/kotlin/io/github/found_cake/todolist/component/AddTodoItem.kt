package io.github.found_cake.todolist.component

import emotion.react.css
import io.github.found_cake.todolist.extention.addClass
import react.FC
import react.Props
import react.dom.html.AutoComplete
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState
import web.cssom.*
import web.html.InputType
import web.prompts.alert

external interface AddTodoItemProps: Props{
	var addTodoItem: (String) -> Unit
}

val AddTodoItem = FC<AddTodoItemProps> {props ->
	var text by useState("")

	fun onSubmit() {
		if(text.isBlank()){
			alert("Cannot add spaces")
			return
		}
		props.addTodoItem(text)
		text = ""
	}

	div{
		css {
			width = 99.pct
			margin = 0.px
			padding = 0.px
		}
		addClass("row")
		input{
			css {
				width = 100.pct.minus(60.px)
				height = 35.px
			}
			addClass("form-control")

			autoComplete = AutoComplete.off
			name = "todo"
			type = InputType.text
			value = text
			onKeyUp = { event ->
				if(event.key == "Enter"){
					onSubmit()
				}
			}
			onChange = { event ->
				text = event.currentTarget.value
			}
		}
		button{
			+ "ADD"
			onClick = {
				onSubmit()
			}
			css {
				height = 35.px
				width = 60.px
				float = Float.right
			}

			addClass("btn btn-primary")
		}
	}
}