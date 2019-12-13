package rubikscube.meta

import rubikscube.meta.Direction._
import rubikscube.meta.Face._

case class Move private (face: Face, direction: Direction) {
  override def toString(): String = {
    s"face: ${face}, direction: $direction"
  }

  def oppose(): Move = {
    this match {
      case Move.FRONT_CLOCKWISE => Move.FRONT_ANTI_CLOCKWISE
      case Move.FRONT_ANTI_CLOCKWISE => Move.FRONT_CLOCKWISE
      case Move.BACK_CLOCKWISE => Move.BACK_ANTI_CLOCKWISE
      case Move.BACK_ANTI_CLOCKWISE => Move.BACK_CLOCKWISE
      case Move.LEFT_CLOCKWISE => Move.LEFT_ANTI_CLOCKWISE
      case Move.LEFT_ANTI_CLOCKWISE => Move.LEFT_CLOCKWISE
      case Move.RIGHT_CLOCKWISE => Move.RIGHT_ANTI_CLOCKWISE
      case Move.RIGHT_ANTI_CLOCKWISE => Move.RIGHT_CLOCKWISE
      case Move.TOP_CLOCKWISE => Move.TOP_ANTI_CLOCKWISE
      case Move.TOP_ANTI_CLOCKWISE => Move.TOP_CLOCKWISE
      case Move.BOTTOM_CLOCKWISE => Move.BOTTOM_ANTI_CLOCKWISE
      case Move.BOTTOM_ANTI_CLOCKWISE => Move.BOTTOM_CLOCKWISE
      case _ => throw new IllegalStateException("Unknown move")
    }
  }
}

object Move {
  val FRONT_CLOCKWISE = Move(FRONT, CLOCKWISE)
  val FRONT_ANTI_CLOCKWISE = Move(FRONT, ANTI_CLOCKWISE)

  val BACK_CLOCKWISE = Move(BACK, CLOCKWISE)
  val BACK_ANTI_CLOCKWISE = Move(BACK, ANTI_CLOCKWISE)

  val LEFT_CLOCKWISE = Move(LEFT, CLOCKWISE)
  val LEFT_ANTI_CLOCKWISE = Move(LEFT, ANTI_CLOCKWISE)

  val RIGHT_CLOCKWISE = Move(RIGHT, CLOCKWISE)
  val RIGHT_ANTI_CLOCKWISE = Move(RIGHT, ANTI_CLOCKWISE)

  val TOP_CLOCKWISE = Move(TOP, CLOCKWISE)
  val TOP_ANTI_CLOCKWISE = Move(TOP, ANTI_CLOCKWISE)

  val BOTTOM_CLOCKWISE = Move(BOTTOM, CLOCKWISE)
  val BOTTOM_ANTI_CLOCKWISE = Move(BOTTOM, ANTI_CLOCKWISE)

  val ALL_MOVES = Set(FRONT_CLOCKWISE, FRONT_ANTI_CLOCKWISE,
                      BACK_CLOCKWISE, BACK_ANTI_CLOCKWISE,
                      LEFT_CLOCKWISE, LEFT_ANTI_CLOCKWISE,
                      RIGHT_CLOCKWISE, RIGHT_ANTI_CLOCKWISE,
                      TOP_CLOCKWISE, TOP_ANTI_CLOCKWISE,
                      BOTTOM_CLOCKWISE, BOTTOM_ANTI_CLOCKWISE)
}
