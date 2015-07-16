import scala.swing.{Swing, ProgressBar}

/**
 * Created by Pierre-Elie on 15/07/15.
 */

class StateProgressBar(title: String) extends ProgressBar {
	min = 0
	max = 100
	value = 100
	label = title
	indeterminate = false
	labelPainted = true
	border = Swing.EmptyBorder(20, 15, 0, 10)
}
