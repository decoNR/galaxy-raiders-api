package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

class Asteroid(
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double,
  ///////////////////
  var isTriggered: Boolean = false
  ///////////////////
) :
  SpaceObject("Asteroid", '.', initialPosition, initialVelocity, radius, mass){
    ///////////////////
    fun isTriggered() {
      this.isTriggered = true
    }
    ///////////////////
  }
