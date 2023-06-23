package io.github.found_cake.todolist.component

import csstype.px
import csstype.rem
import emotion.react.css
import kotlinx.browser.window
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1

val Header = FC<Props> {
	div{
		h1 {
			+"TodoList"
			css {
				fontSize = 60.px
				margin = 0.px
				marginLeft = if(window.screen.width > 768) 1.rem else null
			}
		}
		css {
			marginBottom = 1.rem
		}
	}
}