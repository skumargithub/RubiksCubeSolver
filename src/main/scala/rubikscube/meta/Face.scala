package rubikscube.meta

case class Face private (face: String) {
  override def toString(): String = {
    face
  }
}

object Face {
  val FRONT = Face("FRONT")
  val BACK = Face("BACK")
  val LEFT = Face("LEFT")
  val RIGHT = Face("RIGHT")
  val TOP = Face("TOP")
  val BOTTOM = Face("BOTTOM")

  val ALL_FACES = Set(FRONT, BACK, LEFT, RIGHT, TOP, BOTTOM)
}
