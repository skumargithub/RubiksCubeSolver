package rubikscube.cube

import rubikscube.meta.Color._
import rubikscube.meta.Move
import rubikscube.meta.Face._
import rubikscube.meta.Direction._
import rubikscube.piece.{Edge, Vertex}

class Cube(val frontLayer: Layer, val backLayer: Layer, val leftLayer: Layer, val rightLayer: Layer, val topLayer: Layer, val bottomLayer: Layer) {
   override def equals(other: Any): Boolean = {
    other match {
      case that: Cube => {
        frontLayer.equals(that.frontLayer) && backLayer.equals(that.backLayer) &&
        leftLayer.equals(that.leftLayer) && rightLayer.equals(that.rightLayer) &&
        topLayer.equals(that.topLayer) && bottomLayer.equals(that.bottomLayer)
      }

      case _ => false
    }
  }

  override def toString(): String = {
    "Front\n" +
    frontLayer + "\n" +
    "Back\n" +
    backLayer + "\n" +
    "Left\n" +
    leftLayer + "\n" +
    "Right\n" +
    rightLayer + "\n" +
    "Top\n" +
    topLayer + "\n" +
    "Bottom\n" +
    bottomLayer + "\n"
  }

  def move(mv: Move): Cube = {
    mv.face match {
      case FRONT => {
        mv.direction match {
          case CLOCKWISE => {
            val newFrontLayer = frontLayer.move(mv.direction)
            val newLeftLayer = new Layer(leftLayer.faceColor,
              leftLayer.topLeftVertex, bottomLayer.topLeftVertex, bottomLayer.topRightVertex, leftLayer.bottomLeftVertex,
              leftLayer.topEdge, bottomLayer.topEdge, leftLayer.bottomEdge, leftLayer.leftEdge)

            val newRightLayer = new Layer(rightLayer.faceColor,
              topLayer.topRightVertex, rightLayer.topRightVertex, rightLayer.bottomRightVertex, topLayer.topLeftVertex,
              rightLayer.topEdge, rightLayer.rightEdge, rightLayer.bottomEdge, frontLayer.topEdge.flip())

            val newTopLayer = new Layer(topLayer.faceColor,
              leftLayer.topRightVertex, leftLayer.bottomRightVertex, topLayer.bottomRightVertex, topLayer.bottomLeftVertex,
              leftLayer.rightEdge, topLayer.rightEdge, topLayer.bottomEdge, topLayer.leftEdge)

            val newBottomLayer = new Layer(bottomLayer.faceColor,
              rightLayer.bottomLeftVertex, rightLayer.topLeftVertex, bottomLayer.bottomRightVertex, bottomLayer.bottomLeftVertex,
              rightLayer.leftEdge, bottomLayer.rightEdge, bottomLayer.bottomEdge, bottomLayer.leftEdge)

            new Cube(newFrontLayer, backLayer, newLeftLayer, newRightLayer, newTopLayer, newBottomLayer)
          }
          case ANTICLOCKWISE => {
            val newFrontLayer = frontLayer.move(mv.direction)
            val newLeftLayer = new Layer(leftLayer.faceColor,
              leftLayer.topLeftVertex, topLayer.topLeftVertex, topLayer.topRightVertex, leftLayer.bottomLeftVertex,
              leftLayer.topEdge, topLayer.topEdge, leftLayer.bottomEdge, leftLayer.leftEdge)

            val newRightLayer = new Layer(rightLayer.faceColor,
              bottomLayer.topRightVertex, rightLayer.topRightVertex, rightLayer.bottomRightVertex, bottomLayer.topLeftVertex,
              rightLayer.topEdge, rightLayer.rightEdge, rightLayer.bottomEdge, bottomLayer.topEdge)

            val newTopLayer = new Layer(topLayer.faceColor,
              rightLayer.bottomLeftVertex, rightLayer.topLeftVertex, topLayer.bottomRightVertex, topLayer.bottomLeftVertex,
              rightLayer.leftEdge, topLayer.rightEdge, topLayer.bottomEdge, topLayer.leftEdge)

            val newBottomLayer = new Layer(bottomLayer.faceColor,
              leftLayer.topRightVertex, leftLayer.bottomRightVertex, bottomLayer.bottomRightVertex, bottomLayer.bottomLeftVertex,
              leftLayer.rightEdge, bottomLayer.rightEdge, bottomLayer.bottomEdge, bottomLayer.leftEdge)

            new Cube(newFrontLayer, backLayer, newLeftLayer, newRightLayer, newTopLayer, newBottomLayer)
          }
        }
      }
      case BACK => {
        mv.direction match {
          case CLOCKWISE => {
            val c1 = Cube(backLayer, frontLayer, rightLayer, leftLayer, topLayer.flipOrientation(), bottomLayer.flipOrientation()).move(Move(FRONT, CLOCKWISE))

            // Now flip it back
            Cube(c1.backLayer, c1.frontLayer, c1.rightLayer, c1.leftLayer, c1.topLayer.flipOrientation(), c1.bottomLayer.flipOrientation())
          }
          case ANTICLOCKWISE=> {
            val c1 = Cube(backLayer, frontLayer, rightLayer, leftLayer, topLayer.flipOrientation(), bottomLayer.flipOrientation()).move(Move(FRONT, ANTICLOCKWISE))

            // Now flip it back
            Cube(c1.backLayer, c1.frontLayer, c1.rightLayer, c1.leftLayer, c1.topLayer.flipOrientation(), c1.bottomLayer.flipOrientation())
          }
        }
      }
      case LEFT => {
        mv.direction match {
          case CLOCKWISE => {
            val c1 = Cube(leftLayer, rightLayer, backLayer, frontLayer, topLayer.reorient(LEFT), bottomLayer.reorient(RIGHT))
//            print(s"reoriented\n ${c1}")

            val c2 = c1.move(Move(FRONT, CLOCKWISE))
//            print(s"rotated\n ${c2}")

            // Now flip it back
            Cube(c2.rightLayer, c2.leftLayer, c2.frontLayer, c2.backLayer, c2.topLayer.reorient(RIGHT), c2.bottomLayer.reorient(LEFT))
          }
          case ANTICLOCKWISE=> {
            val c1 = Cube(leftLayer, rightLayer, backLayer, frontLayer, topLayer.reorient(LEFT), bottomLayer.reorient(RIGHT))
            //            print(s"reoriented\n ${c1}")

            val c2 = c1.move(Move(FRONT, ANTICLOCKWISE))
            //            print(s"rotated\n ${c2}")

            // Now flip it back
            Cube(c2.rightLayer, c2.leftLayer, c2.frontLayer, c2.backLayer, c2.topLayer.reorient(RIGHT), c2.bottomLayer.reorient(LEFT))
          }
        }
      }
      case RIGHT => {
        mv.direction match {
          case CLOCKWISE => {
            val c1 = Cube(rightLayer, leftLayer, frontLayer, backLayer, topLayer.reorient(RIGHT), bottomLayer.reorient(LEFT))
            //            print(s"reoriented\n ${c1}")

            val c2 = c1.move(Move(FRONT, CLOCKWISE))
            //            print(s"rotated\n ${c2}")

            // Now flip it back
            Cube(c2.leftLayer, c2.rightLayer, c2.backLayer, c2.frontLayer, c2.topLayer.reorient(LEFT), c2.bottomLayer.reorient(RIGHT))
          }
          case ANTICLOCKWISE=> {
            val c1 = Cube(rightLayer, leftLayer, frontLayer, backLayer, topLayer.reorient(RIGHT), bottomLayer.reorient(LEFT))
            //            print(s"reoriented\n ${c1}")

            val c2 = c1.move(Move(FRONT, ANTICLOCKWISE))
            //            print(s"rotated\n ${c2}")

            // Now flip it back
            Cube(c2.leftLayer, c2.rightLayer, c2.backLayer, c2.frontLayer, c2.topLayer.reorient(LEFT), c2.bottomLayer.reorient(RIGHT))
          }
        }
      }
      case TOP => {
        new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer.move(mv.direction), bottomLayer)
      }
      case BOTTOM => {
        new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer.move(mv.direction))
      }
    }
  }

}

object Cube {
  val frontLayer = new Layer(WHITE,
    new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
    new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

  val backLayer = new Layer(YELLOW,
    new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE),
    new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

  val leftLayer = new Layer(GREEN,
    new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW),
    new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

  val rightLayer = new Layer(BLUE,
    new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE),
    new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

  val topLayer = new Layer(ORANGE,
    new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE),
    new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE))

  val bottomLayer = new Layer(RED,
    new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN),
    new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

  val solvedCube = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)

  def apply(frontLayer: Layer, backLayer: Layer, leftLayer: Layer, rightLayer: Layer, topLayer: Layer, bottomLayer: Layer): Cube = {
    new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
  }

  def main(args: Array[String]): Unit = {
    println("Hello Cube")

    println(solvedCube)
  }
}