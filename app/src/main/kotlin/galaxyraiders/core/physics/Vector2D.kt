@file:Suppress("UNUSED_PARAMETER") // <- REMOVE
package galaxyraiders.core.physics

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("unit", "normal", "degree", "magnitude")
data class Vector2D(val dx: Double, val dy: Double) {
  override fun toString(): String {
    return "Vector2D(dx=$dx, dy=$dy)"
  }

  val magnitude: Double
    get() = Math.sqrt(this.dx * this.dx + this.dy * this.dy)

  val radiant: Double
    get() = Math.atan2(this.dy, this.dx)

  val degree: Double
    get() = Math.toDegrees(radiant)

  val unit: Vector2D
    get() {
      val mag = this.magnitude
      return if (mag != 0.0) Vector2D(this.dx / mag, this.dy / mag) else INVALID_VECTOR
    }

  val normal: Vector2D
    get() = Vector2D(this.dy, -this.dx).unit

  operator fun times(scalar: Double): Vector2D {
    return Vector2D(this.dx * scalar, this.dy * scalar)
  }

  operator fun div(scalar: Double): Vector2D {
    return Vector2D(this.dx / scalar, this.dy / scalar)
  }

  operator fun times(v: Vector2D): Double {
    return this.dx * v.dx + this.dy * v.dy
  }

  operator fun plus(v: Vector2D): Vector2D {
    return Vector2D(this.dx + v.dx, this.dy + v.dy)
  }

  operator fun plus(p: Point2D): Point2D {
    return Point2D(p.x + this.dx, p.y + this.dy)
  }

  operator fun unaryMinus(): Vector2D {
    return Vector2D(-this.dx, -this.dy)
  }

  operator fun minus(v: Vector2D): Vector2D {
    return Vector2D(dx - v.dx, dy - v.dy)
  }

  fun scalarProject(target: Vector2D): Double {
    val targetMag = target.magnitude
    return if (targetMag != 0.0) (this * target) / targetMag else INVALID_DOUBLE
  }

  fun vectorProject(target: Vector2D): Vector2D {
    val targetMag = target.magnitude
    return ((this.scalarProject(target) * target) / target.magnitude)
  }
}

operator fun Double.times(v: Vector2D): Vector2D {
  return v * this
}
