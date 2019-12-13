package rubikscube.cube

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import rubikscube.meta.Color._
import rubikscube.meta.Face._
import rubikscube.meta.Direction._
import rubikscube.meta.Move
import rubikscube.piece.{Edge, Vertex}

@RunWith(classOf[JUnitRunner])
class LayerSuite extends FunSuite {
  test("Layer equality and not equality") {

    val faceColor = WHITE
    val topLeftVertex = new Vertex(WHITE, GREEN, ORANGE)
    val topEdge = new Edge(WHITE, ORANGE)
    val topRightVertex = new Vertex(WHITE, ORANGE, BLUE)
    val rightEdge = new Edge(WHITE, BLUE)
    val bottomRightVertex = new Vertex(WHITE, BLUE, RED)
    val bottomEdge = new Edge(WHITE, RED)
    val bottomLeftVertex = new Vertex(WHITE, RED, GREEN)
    val leftEdge = new Edge(WHITE, GREEN)

    val layer1 = new Layer(faceColor,
                          topLeftVertex, topRightVertex, bottomRightVertex, bottomLeftVertex,
                          topEdge, rightEdge, bottomEdge, leftEdge)

    assert(layer1 equals layer1)
//    println("This is layer1")
//    println(layer1)

    val layer2 = new Layer(faceColor,
      topLeftVertex, topRightVertex, bottomRightVertex, bottomLeftVertex,
      topEdge, rightEdge, bottomEdge, leftEdge)
    assert(layer1.equals(layer2) == true)

    val layer3 = new Layer(BLUE,
      topLeftVertex, topRightVertex, bottomRightVertex, bottomLeftVertex,
      topEdge, rightEdge, bottomEdge, leftEdge)

    assert(layer1.equals(layer3) != true)
//    println("This is layer3")
//    println(layer3)
  }

  test("Move clockwise and anti-clockwise") {

    val faceColor = WHITE
    val topLeftVertex = new Vertex(WHITE, GREEN, ORANGE)
    val topEdge = new Edge(WHITE, ORANGE)
    val topRightVertex = new Vertex(WHITE, ORANGE, BLUE)
    val rightEdge = new Edge(WHITE, BLUE)
    val bottomRightVertex = new Vertex(WHITE, BLUE, RED)
    val bottomEdge = new Edge(WHITE, RED)
    val bottomLeftVertex = new Vertex(WHITE, RED, GREEN)
    val leftEdge = new Edge(WHITE, GREEN)

    val l1 = new Layer(faceColor,
      topLeftVertex, topRightVertex, bottomRightVertex, bottomLeftVertex,
      topEdge, rightEdge, bottomEdge, leftEdge)

    val l2 = l1.move(CLOCKWISE).move(ANTI_CLOCKWISE)
    assert(l1.equals(l2) == true)
  }
}
