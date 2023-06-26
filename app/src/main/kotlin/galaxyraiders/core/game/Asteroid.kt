package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

class Asteroid(
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double,
  var isExploded: Boolean = false
) :
  SpaceObject("Asteroid", '.', initialPosition, initialVelocity, radius, mass) {
  fun explode() {
    this.isExploded = true
  }
  fun isAlive(): Boolean {
    return !this.isExploded
  }
}
