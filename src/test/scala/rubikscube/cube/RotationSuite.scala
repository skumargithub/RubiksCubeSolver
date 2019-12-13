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
class RotationSuite extends FunSuite {
  test("Front layer clockwise rotation") {
    val cr = Cube.solvedCube.move(Move(FRONT, CLOCKWISE))
//    println(s"FRONT clockwise rotation\n ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(WHITE, RED, GREEN), new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED),
      new Edge(WHITE, GREEN), new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED))

    val backLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val leftLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(GREEN, RED, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(RED, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val rightLayer = new Layer(BLUE,
      new Vertex(ORANGE, WHITE, GREEN), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(ORANGE, BLUE, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(ORANGE, WHITE))

    val topLayer = new Layer(ORANGE,
      new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE),
      new Edge(GREEN, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN), new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE),
      new Edge(RED, YELLOW), new Edge(RED, GREEN), new Edge(BLUE, WHITE), new Edge(RED, BLUE))

    val cg = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated FRONT clockwise rotation\n ${cg}")

    assert(cr.equals(cg) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = cr.move(Move(FRONT, ANTI_CLOCKWISE))
    assert(c3.equals(Cube.solvedCube) == true)

    // Move the Front layer of a solved cube clockwise 4 times to get back the solved cube
    val mv = Move(FRONT, CLOCKWISE)
    val c4 = Cube.solvedCube.move(mv).move(mv).move(mv).move(mv)
    assert(c4.equals(Cube.solvedCube) == true)
  }

  test("Front layer anti-clockwise rotation") {
    val cr = Cube.solvedCube.move(Move(FRONT, ANTI_CLOCKWISE))
//    println(s"Front anti-clockwise rotation\n ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN), new Vertex(WHITE, GREEN, ORANGE),
      new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN), new Edge(WHITE, ORANGE))

    val backLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val leftLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(GREEN, RED, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(ORANGE, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val rightLayer = new Layer(BLUE,
      new Vertex(RED, WHITE, BLUE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(RED, GREEN, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(RED, WHITE))

    val topLayer = new Layer(ORANGE,
      new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE),
      new Edge(BLUE, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED),
      new Edge(RED, YELLOW), new Edge(RED, GREEN), new Edge(GREEN, WHITE), new Edge(RED, BLUE))

    val cg = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated front anti-clockwise rotation\n ${cg}")
    assert(cr.equals(cg) == true)

    // Move the Front layer clockwise to get back the solved cube
    val c3 = cr.move(Move(FRONT, CLOCKWISE))
//    println(s"Generated front anti-clockwise then clockwise rotation\n ${c3}")
    assert(c3.equals(Cube.solvedCube) == true)

    // Move the Front layer clockwise 4 times to get back the solved cube
    val mv = Move(FRONT, CLOCKWISE)
    val c4 = Cube.solvedCube.move(mv).move(mv).move(mv).move(mv)
    assert(c4.equals(Cube.solvedCube) == true)
  }
}
