package rubikscube.meta

case class Color private (color: String) {
  override def toString(): String = {
    color
  }
}

object Color {
  val WHITE = Color("W")
  val RED = Color("R")
  val ORANGE = Color("O")
  val GREEN = Color("G")
  val BLUE = Color("B")
  val YELLOW = Color("Y")

  val ALL_COLORS = Set(WHITE, RED, ORANGE, GREEN, BLUE, YELLOW)
}
