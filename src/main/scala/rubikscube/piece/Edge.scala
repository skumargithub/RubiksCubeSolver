package rubikscube.piece

import rubikscube.meta.Color

// Inside and then outside
sealed class Edge(val surface1: Color, val surface2: Color, val surface1Match: Boolean = true, val surface2Match: Boolean = true) {
  override def equals(other: Any): Boolean = other match {
    case that: Edge =>
      (!surface1Match || surface1 == that.surface1) &&    // Match on the surfaces only if told to
      (!surface2Match || surface2 == that.surface2)
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(surface1, surface2, surface1Match, surface2Match)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
