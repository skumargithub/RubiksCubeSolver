package rubikscube.meta

case class Direction private (directon: String) {
  override def toString(): String = {
    directon
  }

  def oppose(): Direction = {
    this match {
      case Direction.CLOCKWISE => Direction.ANTI_CLOCKWISE
      case Direction.ANTI_CLOCKWISE => Direction.CLOCKWISE
      case _ => throw new IllegalStateException("Invalid Direction!")
    }
  }
}

object Direction {
  val CLOCKWISE = Direction("CLOCKWISE")
  val ANTI_CLOCKWISE = Direction("ANTI_CLOCKWISE")

  val ALL_DIRECTIONS = Set(CLOCKWISE, ANTI_CLOCKWISE)
}