package io.github.found_cake.todolist.component

import emotion.react.css
import io.github.found_cake.todolist.extention.addClass
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import web.cssom.FontWeight
import web.cssom.rem

val Header = FC<Props> {
	div{
		h1 {
			+"TodoList"
			css {
				fontWeight = FontWeight.bold
			}
			addClass("title")
		}
		css {
			marginTop = 0.3.rem
			marginBottom = 0.7.rem
		}
	}
}
