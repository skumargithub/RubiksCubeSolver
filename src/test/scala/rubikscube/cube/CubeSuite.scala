package rubikscube.cube

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import rubikscube.meta.Color._
import rubikscube.meta.Face._
import rubikscube.meta.Direction._
import rubikscube.piece.{Edge, Vertex}
import rubikscube.meta.Move

@RunWith(classOf[JUnitRunner])
class CubeSuite extends FunSuite {
  test("Cube equality and not equality") {
    assert(Cube.solvedCube.equals(Cube.solvedCube) == true)

    // Re-create the solved cube and test equality

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

    val solvedCube = Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    assert(Cube.solvedCube.equals(solvedCube) == true)

    // Created a mish-mash cube and test inequality
    val mishMashCube = Cube(backLayer, frontLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    assert(Cube.solvedCube.equals(mishMashCube) == false)
  }
}
