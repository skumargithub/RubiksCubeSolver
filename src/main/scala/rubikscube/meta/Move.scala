package rubikscube.meta

import rubikscube.meta.Direction._
import rubikscube.meta.Face._

class Move(val face: Face, val direction: Direction)

object Move {
  def apply(face: Face, direction: Direction): Move = {
    new Move(face, direction)
  }
}
