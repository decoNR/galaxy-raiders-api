package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

class Explosion(
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double,
  var lifeDuration: Int = 3
) :
  SpaceObject("Explosion", '*', initialPosition, initialVelocity, radius, mass) {
  fun aging() {
    this.lifeDuration -= 1
  }
  fun isAlive(): Boolean {
    return this.lifeDuration > 0
  }
}
