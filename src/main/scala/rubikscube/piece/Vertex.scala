package rubikscube.piece

import rubikscube.meta.Color._
import rubikscube.meta.Direction._

// In clockwise order starting with the front face
sealed class Vertex(val surface1: Color, val surface2: Color, val surface3: Color,
                    val surface1Match: Boolean = true, val surface2Match: Boolean = true, val surface3Match: Boolean = true) {
  override def equals(other: Any): Boolean = other match {
    case that: Vertex =>
      (!surface1Match || surface1 == that.surface1) &&    // Match on the surfaces only if told to
      (!surface2Match || surface2 == that.surface2) &&
      (!surface3Match || surface3 == that.surface3)
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(surface1, surface2, surface3, surface1Match, surface2Match, surface3Match)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
