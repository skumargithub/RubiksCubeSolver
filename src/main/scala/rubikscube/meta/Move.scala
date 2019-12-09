package rubikscube.meta

import rubikscube.meta.Direction._
import rubikscube.meta.Face._

class Move(val face: Face, val direction: Direction) {
  override def toString(): String = {
    s"face: ${face}, direction: $direction"
  }
}

object Move {
  def apply(face: Face, direction: Direction): Move = {
    new Move(face, direction)
  }

  val FRONT_CLOCKWISE = Move(FRONT, CLOCKWISE)
  val FRONT_ANTICLOCKWISE = Move(FRONT, ANTICLOCKWISE)

  val BACK_CLOCKWISE = Move(BACK, CLOCKWISE)
  val BACK_ANTICLOCKWISE = Move(BACK, ANTICLOCKWISE)

  val LEFT_CLOCKWISE = Move(LEFT, CLOCKWISE)
  val LEFT_ANTICLOCKWISE = Move(LEFT, ANTICLOCKWISE)

  val RIGHT_CLOCKWISE = Move(RIGHT, CLOCKWISE)
  val RIGHT_ANTICLOCKWISE = Move(RIGHT, ANTICLOCKWISE)

  val TOP_CLOCKWISE = Move(TOP, CLOCKWISE)
  val TOP_ANTICLOCKWISE = Move(TOP, ANTICLOCKWISE)

  val BOTTOM_CLOCKWISE = Move(BOTTOM, CLOCKWISE)
  val BOTTOM_ANTICLOCKWISE = Move(BOTTOM, ANTICLOCKWISE)

  val ALL_MOVES = Set(FRONT_CLOCKWISE, FRONT_ANTICLOCKWISE,
                      BACK_CLOCKWISE, BACK_ANTICLOCKWISE,
                      LEFT_CLOCKWISE, LEFT_ANTICLOCKWISE,
                      RIGHT_CLOCKWISE, RIGHT_ANTICLOCKWISE,
                      TOP_CLOCKWISE, TOP_ANTICLOCKWISE,
                      BOTTOM_CLOCKWISE, BOTTOM_ANTICLOCKWISE)
}

