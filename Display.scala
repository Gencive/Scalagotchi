import javax.swing.ImageIcon

import scala.swing._
import scala.swing.BorderPanel.Position._
import scala.swing.event.{Event, ButtonClicked}

/**
 * Created by Pierre-Elie on 15/07/15.
 */

case object EatEvent extends Event
case object BathEvent extends Event
case object PoopEvent extends Event
case object PlayEvent extends Event

class Display extends Publisher {
	val frame = new MainFrame()
	val eatButton = new ActionButton("EAT")
	val bathButton = new ActionButton("BATH")
	val poopButton = new ActionButton("POOP")
	val playButton = new ActionButton("PLAY")
	val lifeBar = new StateProgressBar("LIFE")
	val hygieneBar = new StateProgressBar("HYGIENE")
	val happinessBar = new StateProgressBar("HAPPINESS")
	val hungryBar = new StateProgressBar("HUNGRY")
	val label: Label = new Label()

	def createWindow() = {
		frame.listenTo(eatButton, bathButton, poopButton, playButton)

		label.icon = new ImageIcon("misc/minion_basic.jpg")

		val buttonPanel = new BoxPanel(Orientation.Horizontal) {
			contents += eatButton
			contents += bathButton
			contents += poopButton
			contents += playButton
			border = Swing.EmptyBorder(0, 50, 20, 50)
		}

		val barPanel = new BoxPanel(Orientation.Horizontal) {
			contents += lifeBar
			contents += hygieneBar
			contents += happinessBar
			contents += hungryBar
		}

		frame.contents = new BorderPanel {
			layout(buttonPanel) = South
			layout(label) = Center
			layout(barPanel) = North
		}

		frame.reactions += {
			case ButtonClicked(component) if component == eatButton => publish(EatEvent)
			case ButtonClicked(component) if component == bathButton => publish(BathEvent)
			case ButtonClicked(component) if component == poopButton => publish(PoopEvent)
			case ButtonClicked(component) if component == playButton => publish(PlayEvent)
		}
	}

	def init() {
		frame.title = "Scalagotchi"
		frame.preferredSize = new Dimension(720, 480)
		frame.resizable = false

		createWindow()
	}

	def updateImage(url: String) = label.icon = new ImageIcon(url)

	def deathScreen() {
		val label = new Label("Game Over")
		frame.contents = label
	}

	def reaction(reaction: Reactions) = frame.reactions += reaction

	def display() = frame.visible = true
}
