import scala.swing.{Dimension, Button}

/**
 * Created by Pierre-Elie on 15/07/15.
 */

class ActionButton(title: String) extends Button {
	val buttonSize = new Dimension(150, 70)
	preferredSize = buttonSize
	minimumSize = buttonSize
	maximumSize = buttonSize
	text = title
}
