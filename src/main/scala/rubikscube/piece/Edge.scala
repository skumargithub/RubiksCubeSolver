package rubikscube.piece

import rubikscube.cube.Layer
import rubikscube.meta.Color._
import rubikscube.meta.Direction.{ANTICLOCKWISE, CLOCKWISE}
import rubikscube.meta.Move

// Inside and then outside
sealed class Edge(val surface1: Color, val surface2: Color) {
  override def equals(other: Any): Boolean = other match {
    case that: Edge =>
        surface1 == that.surface1 &&
        surface2 == that.surface2
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(surface1, surface2)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  def flip(): Edge = {
    new Edge(surface2, surface1)
  }
}
