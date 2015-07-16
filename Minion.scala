/**
 * Created by Pierre-Elie on 15/07/15.
 */

class Minion {
	var life = 100
	var happiness = 100
	var hygiene = 100
	var hungry = 100


	def eat() = {
		setLife(life + 20)
		setHygiene(hygiene - 10)
		setHungry(hungry + 20)
	}

	def bath() = {
		setHappiness(happiness - 20)
		setHygiene(hygiene + 10)
		setHungry(hungry - 10)
	}

	def poop() = {
		setHappiness(happiness + 10)
		setHygiene(hygiene - 20)
		setHungry(hungry - 10)
	}

	def play() = {
		setLife(life - 10)
		setHappiness(happiness + 20)
		setHungry(hungry - 10)
	}


	def setLife(value: Int) = if (value > 100) life = 100 else life = value

	def setHappiness(value: Int) = if (value > 100) happiness = 100 else happiness = value

	def setHygiene(value: Int) = if (value > 100) this.hygiene = 100 else hygiene = value

	def setHungry(value: Int) = if (value > 100) hungry = 100 else hungry = value

	def dead() = if (life <= 0 || happiness <= 0 || hygiene <= 0 || hungry <= 0) true else false
}
