package rubikscube.cube

import rubikscube.meta.Color._
import rubikscube.meta.Move
import rubikscube.meta.Face
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

  // Reorient the given face to FRONT
  def reorientToFront(face: Face): Cube = {
    face match {
      case BACK => Cube(backLayer, frontLayer, rightLayer, leftLayer, topLayer.flipOrientation(), bottomLayer.flipOrientation())
      case LEFT => Cube(leftLayer, rightLayer, backLayer, frontLayer, topLayer.reorient(LEFT), bottomLayer.reorient(RIGHT))
      case RIGHT => Cube(rightLayer, leftLayer, frontLayer, backLayer, topLayer.reorient(RIGHT), bottomLayer.reorient(LEFT))
      case TOP => Cube(topLayer, bottomLayer.flipOrientation(), rightLayer.reorient(RIGHT), leftLayer.reorient(LEFT), frontLayer, backLayer.flipOrientation())
      case BOTTOM => Cube(bottomLayer, topLayer.flipOrientation(), rightLayer.reorient(LEFT), leftLayer.reorient(RIGHT), backLayer.flipOrientation(), frontLayer)
      case FRONT => this      // Front reoriented to Front => Front
      case _ => throw new IllegalStateException("Illegal Face!")
    }
  }

  def move(mv: Move): Cube = {
    mv.face match {
      case FRONT => {
        mv.direction match {
          case CLOCKWISE => {
            val newFrontLayer = frontLayer.move(mv.direction)
            val newLeftLayer = new Layer(leftLayer.faceColor,
              leftLayer.topLeftVertex, bottomLayer.bottomRightVertex, bottomLayer.bottomLeftVertex, leftLayer.bottomLeftVertex,
              leftLayer.topEdge, bottomLayer.bottomEdge, leftLayer.bottomEdge, leftLayer.leftEdge)

            val newRightLayer = new Layer(rightLayer.faceColor,
              topLayer.topRightVertex, rightLayer.topRightVertex, rightLayer.bottomRightVertex, topLayer.topLeftVertex,
              rightLayer.topEdge, rightLayer.rightEdge, rightLayer.bottomEdge, topLayer.topEdge)

            val newTopLayer = new Layer(topLayer.faceColor,
              leftLayer.topRightVertex, leftLayer.bottomRightVertex, topLayer.bottomRightVertex, topLayer.bottomLeftVertex,
              leftLayer.rightEdge, topLayer.rightEdge, topLayer.bottomEdge, topLayer.leftEdge)

            val newBottomLayer = new Layer(bottomLayer.faceColor,
              bottomLayer.topLeftVertex, bottomLayer.topRightVertex, rightLayer.bottomLeftVertex, rightLayer.topLeftVertex,
              bottomLayer.topEdge, bottomLayer.rightEdge, rightLayer.leftEdge, bottomLayer.leftEdge)

            new Cube(newFrontLayer, backLayer, newLeftLayer, newRightLayer, newTopLayer, newBottomLayer)
          }
          case ANTI_CLOCKWISE => {
            val newFrontLayer = frontLayer.move(mv.direction)
            val newLeftLayer = new Layer(leftLayer.faceColor,
              leftLayer.topLeftVertex, topLayer.topLeftVertex, topLayer.topRightVertex, leftLayer.bottomLeftVertex,
              leftLayer.topEdge, topLayer.topEdge, leftLayer.bottomEdge, leftLayer.leftEdge)

            val newRightLayer = new Layer(rightLayer.faceColor,
              bottomLayer.bottomLeftVertex, rightLayer.topRightVertex, rightLayer.bottomRightVertex, bottomLayer.bottomRightVertex,
              rightLayer.topEdge, rightLayer.rightEdge, rightLayer.bottomEdge, bottomLayer.bottomEdge)

            val newTopLayer = new Layer(topLayer.faceColor,
              rightLayer.bottomLeftVertex, rightLayer.topLeftVertex, topLayer.bottomRightVertex, topLayer.bottomLeftVertex,
              rightLayer.leftEdge, topLayer.rightEdge, topLayer.bottomEdge, topLayer.leftEdge)

            val newBottomLayer = new Layer(bottomLayer.faceColor,
              bottomLayer.topLeftVertex, bottomLayer.topRightVertex, leftLayer.topRightVertex, leftLayer.bottomRightVertex,
              bottomLayer.topEdge, bottomLayer.rightEdge, leftLayer.rightEdge, bottomLayer.leftEdge)

            new Cube(newFrontLayer, backLayer, newLeftLayer, newRightLayer, newTopLayer, newBottomLayer)
          }
          case _ => throw new IllegalStateException("Illegal Direction!")
        }
      }
      case BACK => {
        // Reorient (BACK becomes the FRONT),  do the directional move on the FRONT face
        val cr = this.reorientToFront(BACK).move(Move(FRONT, mv.direction))

        // And reorient (FRONT becomes BACK) it back
        cr.reorientToFront(BACK)
      }
      case LEFT => {
        // Reorient (LEFT becomes the FRONT),  do the directional move on the FRONT face
        val cr = this.reorientToFront(LEFT).move(Move(FRONT, mv.direction))

        // And reorient (RIGHT becomes FRONT) it back
        cr.reorientToFront(RIGHT)
      }
      case RIGHT => {
        // Reorient (RIGHT becomes the FRONT),  do the directional move on the FRONT face
        val cr = this.reorientToFront(RIGHT).move(Move(FRONT, mv.direction))

        // And reorient (LEFT becomes FRONT) it back
        cr.reorientToFront(LEFT)
      }
      case TOP => {
        // Reorient (TOP becomes FRONT), do the directional move on the FRONT face
        val cr = this.reorientToFront(TOP).move(Move(FRONT, mv.direction))

        // And reorient (TOP becomes FRONT) it back
        cr.reorientToFront(TOP)
      }
      case BOTTOM => {
        // Reorient (BOTTOM becomes FRONT), do the directional move on the FRONT face
        val cr = this.reorientToFront(BOTTOM).move(Move(FRONT, mv.direction))

        // And reorient (BOTTOM becomes FRONT) it back
        cr.reorientToFront(BOTTOM)
      }
      case _ => throw new IllegalStateException("Illegal Face!")
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
    new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN), new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE),
    new Edge(RED, YELLOW), new Edge(RED, GREEN), new Edge(RED, WHITE), new Edge(RED, BLUE))

  val solvedCube = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)

  def apply(frontLayer: Layer, backLayer: Layer, leftLayer: Layer, rightLayer: Layer, topLayer: Layer, bottomLayer: Layer): Cube = {
    new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
  }

  def main(args: Array[String]): Unit = {
    println("Hello Cube")

    println(solvedCube)
  }
}
