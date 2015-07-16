import scala.swing.Publisher

/**
 * Created by Pierre-Elie on 13/07/15.
 */

object Main extends Publisher {
	val display = new Display
	var minion = new Minion

	def refresh() {
		if (minion.dead()) display.deathScreen() else
		display.lifeBar.value = minion.life
		display.hygieneBar.value = minion.hygiene
		display.hungryBar.value = minion.hungry
		display.happinessBar.value = minion.happiness
	}

	def main (args: Array[String]) {
		display.init()
		display.display()

		val decreaseLife = new Thread {
			override def run() {
				while (true) {
					Thread.sleep(1000)
					minion.setLife(minion.life - 1)
					refresh()
				}
			}
		}

		listenTo(display)
		reactions += {
			case EatEvent => minion.eat() ; refresh()
			case BathEvent => minion.bath() ; refresh()
			case PoopEvent => minion.poop() ; refresh()
			case PlayEvent => minion.play() ; refresh()
		}

		decreaseLife.run()
	}
}
