@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(this.x + p.x, this.y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(this.x + v.dx, this.y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(this.x, this.y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(p.x - this.x, p.y - this.y)
  }

  fun impactDirection(p: Point2D): Vector2D {
    val iV = impactVector(p)
    return iV / iV.magnitude
  }

  fun contactVector(p: Point2D): Vector2D {
    val iV = impactVector(p)
    return iV.normal
  }

  fun contactDirection(p: Point2D): Vector2D {
    val iD = impactDirection(p)
    return iD.normal
  }

  fun distance(p: Point2D): Double {
    return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y))
  }
}
