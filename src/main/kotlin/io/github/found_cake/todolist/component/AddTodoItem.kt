package io.github.found_cake.todolist.component

import react.FC
import react.Props
import react.dom.html.AutoComplete
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

external interface AddTodoItemProps: Props{
	var addTodoItem: (String) -> Unit
}

val AddTodoItem = FC<AddTodoItemProps> {props ->
	var text by useState("")

	fun onSubmit() {
		props.addTodoItem(text)
		text = ""
	}

	div{
		input{
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
			+ "Add"
			onClick = {
				onSubmit()
			}
		}
	}
}