package rubikscube.piece

import rubikscube.meta.Color._
import rubikscube.meta.Direction._

// In clockwise order starting with the front face
sealed class Vertex(val surface1: Color, val surface2: Color, val surface3: Color) {
  override def equals(other: Any): Boolean = other match {
    case that: Vertex =>
        surface1 == that.surface1 &&
        surface2 == that.surface2 &&
        surface3 == that.surface3
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(surface1, surface2, surface3)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  def downToUp(): Vertex = {
    new Vertex(surface3, surface1, surface2)
  }

  def rotate(direction: Direction): Vertex = {
    direction match {
      case CLOCKWISE => new Vertex(surface3, surface1, surface2)
      case _ => new Vertex(surface2, surface3, surface1)
    }
  }
}
