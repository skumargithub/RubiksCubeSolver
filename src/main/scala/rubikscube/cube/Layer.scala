package rubikscube.cube

import rubikscube.meta.Color._
import rubikscube.meta.Direction._
import rubikscube.meta.Move
import rubikscube.piece.{Edge, Vertex}
import rubikscube.meta.Face._

// A layer consists of a face, it's 4 vertices and 4 edges, in clockwise order, when you look at it
sealed class Layer(val faceColor: Color,
            val topLeftVertex: Vertex, val topRightVertex: Vertex, val bottomRightVertex: Vertex, val bottomLeftVertex: Vertex,
            val topEdge: Edge, val rightEdge: Edge, val bottomEdge: Edge, val leftEdge: Edge) {
  def move(direction: Direction): Layer = {
    direction match {
      case CLOCKWISE =>
        new Layer(faceColor,
                  bottomLeftVertex, topLeftVertex, topRightVertex, bottomRightVertex,
                  leftEdge, topEdge, rightEdge, bottomEdge)
      case ANTICLOCKWISE =>
        new Layer(faceColor,
          topRightVertex, bottomRightVertex, bottomLeftVertex, topLeftVertex,
          rightEdge, bottomEdge, leftEdge, topEdge)
    }
  }

  def flipOrientation(): Layer = {
    new Layer(faceColor,
              bottomRightVertex, bottomLeftVertex, topLeftVertex, topRightVertex,
              bottomEdge, leftEdge, topEdge, rightEdge)
  }

  def reorient(face: Face): Layer = {
    face match {
      case LEFT => {
        new Layer(faceColor, topRightVertex, bottomRightVertex, bottomLeftVertex, topLeftVertex, rightEdge, bottomEdge, leftEdge, topEdge)
      }
      case RIGHT => { // Junk for now
        new Layer(faceColor, bottomLeftVertex, topLeftVertex, topRightVertex, bottomRightVertex, leftEdge, topEdge, rightEdge, bottomEdge)
      }
    }

  }

  def top(): (Vertex, Edge, Vertex) = {
    (topLeftVertex, topEdge, topRightVertex)
  }

  def bottom(): (Vertex, Edge, Vertex) = {
    (bottomLeftVertex, bottomEdge, bottomRightVertex)
  }

  def right(): (Vertex, Edge, Vertex) = {
    (topRightVertex, rightEdge, bottomRightVertex)
  }

  def left(): (Vertex, Edge, Vertex) = {
    (topLeftVertex, leftEdge, bottomLeftVertex)
  }

  override def equals(other: Any): Boolean = other match {
    case that: Layer =>
        faceColor.equals(that.faceColor) &&
        topLeftVertex.equals(that.topLeftVertex) &&
        topRightVertex.equals(that.topRightVertex) &&
        bottomRightVertex.equals(that.bottomRightVertex) &&
        bottomLeftVertex.equals(that.bottomLeftVertex) &&
        topEdge.equals(that.topEdge) &&
        rightEdge.equals(that.rightEdge) &&
        bottomEdge.equals(that.bottomEdge) &&
        leftEdge.equals(that.leftEdge)
    case _ => false
  }

 override def hashCode(): Int = {
    val state = Seq(faceColor, topLeftVertex, topRightVertex, bottomRightVertex, bottomLeftVertex, topEdge, rightEdge, bottomEdge, leftEdge)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString(): String = {
    "    "  + topLeftVertex.surface3 + " " + topEdge.surface2 + " " + topRightVertex.surface2 + "\n" +
    "    \u2191 \u2191 \u2191\n" +
    topLeftVertex.surface2 + " \u2190 " + topLeftVertex.surface1 + "|" + topEdge.surface1 + "|" + topRightVertex.surface1 + " \u2192 " + topRightVertex.surface3 + "\n" +
    leftEdge.surface2 + " \u2190 " + leftEdge.surface1 + "|" + faceColor + "|" + rightEdge.surface1 + " \u2192 " + rightEdge.surface2 + "\n" +
    bottomLeftVertex.surface3 + " \u2190 " + bottomLeftVertex.surface1 + "|" + bottomEdge.surface1 + "|" + bottomRightVertex.surface1 + " \u2192 " + bottomRightVertex.surface2 + "\n" +
      "    \u2193 \u2193 \u2193\n" +
    "    "  + bottomLeftVertex.surface2 + " " + bottomEdge.surface2 + " " + bottomRightVertex.surface3
  }
}
