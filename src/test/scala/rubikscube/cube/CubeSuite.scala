package rubikscube.cube

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import rubikscube.meta.Color._
import rubikscube.meta.Face._
import rubikscube.meta.Direction._
import rubikscube.piece.{Edge, Vertex}
import rubikscube.cube.Cube
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
      new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val solvedCube = Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    assert(Cube.solvedCube.equals(solvedCube) == true)

    // Created a mish-mash cube and test inequality
    val mishMashCube = Cube(backLayer, frontLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    assert(Cube.solvedCube.equals(mishMashCube) == false)
  }

  test("Front layer clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(FRONT, CLOCKWISE))
//    println("\nFront rotation")
//    println(c1)
    assert(Cube.solvedCube.equals(c1) == false)

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
      new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN),
      new Edge(BLUE, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Rotated\n ${c2}")

    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(FRONT, ANTICLOCKWISE))
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Front layer anti-clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(FRONT, ANTICLOCKWISE))
    assert(c1.equals(Cube.solvedCube) == false)
//    println(c1)

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
      new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN),
      new Edge(GREEN, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(c2)

    assert(c1.equals(c2) == true)

    // Move the Front layer clockwise to get back the solved cube
    val c3 = c2.move(Move(FRONT, CLOCKWISE))
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Back layer clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(BACK, CLOCKWISE))
//    println(s"Actual Rotated: ${c1}")
    assert(Cube.solvedCube.equals(c1) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val backLayer = new Layer(YELLOW,
      new Vertex(YELLOW, RED, BLUE), new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED),
      new Edge(YELLOW, BLUE), new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED))

    val leftLayer = new Layer(GREEN,
      new Vertex(ORANGE, YELLOW, BLUE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(ORANGE, GREEN, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(ORANGE, YELLOW))

    val rightLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(RED, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED),
      new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(BLUE, YELLOW), new Edge(ORANGE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(GREEN, RED, YELLOW), new Vertex(GREEN, YELLOW, ORANGE),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(GREEN, YELLOW), new Edge(RED, GREEN))

    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated Rotated\n ${c2}")

    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(BACK, ANTICLOCKWISE))
//    println(s"Perfect\n ${c2}")
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Back layer anti-clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(BACK, ANTICLOCKWISE))
//    println(s"Actual Rotated\n${c1}")
    assert(Cube.solvedCube.equals(c1) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val backLayer = new Layer(YELLOW,
      new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE), new Vertex(YELLOW, BLUE, ORANGE),
      new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE), new Edge(YELLOW, ORANGE))

    val leftLayer = new Layer(GREEN,
      new Vertex(RED, YELLOW, GREEN), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(RED, BLUE, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(RED, YELLOW))

    val rightLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(ORANGE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(GREEN, RED, YELLOW), new Vertex(GREEN, YELLOW, ORANGE),
      new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(GREEN, YELLOW), new Edge(ORANGE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(BLUE, YELLOW), new Edge(RED, GREEN))

    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated Rotated\n ${c2}")

    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(BACK, CLOCKWISE))
    //    println(s"Perfect\n ${c2}")
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Left layer clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(LEFT, CLOCKWISE))
//    println(s"Rotated\n ${c1}")
    assert(Cube.solvedCube.equals(c1) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(ORANGE, GREEN, YELLOW), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(ORANGE, WHITE, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(ORANGE, GREEN))

    val backLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(RED, YELLOW, GREEN), new Vertex(RED, GREEN, WHITE), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(RED, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val leftLayer = new Layer(GREEN,
      new Vertex(GREEN, RED, YELLOW), new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED),
      new Edge(GREEN, YELLOW), new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED))

    val rightLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, BLUE, WHITE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(ORANGE, YELLOW, BLUE),
      new Edge(ORANGE, WHITE), new Edge(YELLOW, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(WHITE, RED, GREEN),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(WHITE, GREEN))


    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    //    println(s"Generated Rotated\n ${c2}")

    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(LEFT, ANTICLOCKWISE))
//        println(s"Perfect\n ${c2}")
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Left layer anticlockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(LEFT, ANTICLOCKWISE))
//    println(s"Rotated\n ${c1}")
    assert(Cube.solvedCube.equals(c1) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(RED, GREEN, WHITE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(RED, YELLOW, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(RED, GREEN))

    val backLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(ORANGE, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val leftLayer = new Layer(GREEN,
      new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW), new Vertex(GREEN, YELLOW, ORANGE),
      new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW), new Edge(GREEN, ORANGE))

    val rightLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, BLUE, WHITE), new Vertex(WHITE, RED, GREEN), new Vertex(WHITE, GREEN, ORANGE), new Vertex(ORANGE, YELLOW, BLUE),
      new Edge(ORANGE, WHITE), new Edge(WHITE, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(YELLOW, GREEN, RED), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(YELLOW, ORANGE, GREEN),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(YELLOW, GREEN))
    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    //    println(s"Generated Rotated\n ${c2}")

    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(LEFT, CLOCKWISE))
    //        println(s"Perfect\n ${c2}")
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Right layer clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(RIGHT, CLOCKWISE))
//    println(s"Rotated\n ${c1}")
    assert(Cube.solvedCube.equals(c1) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(RED, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val backLayer = new Layer(YELLOW,
      new Vertex(ORANGE, BLUE, WHITE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(ORANGE, YELLOW, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(ORANGE, BLUE))

    val leftLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val rightLayer = new Layer(BLUE,
      new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED),
      new Edge(BLUE, WHITE), new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED))

    val topLayer = new Layer(ORANGE,
      new Vertex(WHITE, BLUE, RED), new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(WHITE, ORANGE, BLUE),
      new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(WHITE, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, GREEN, WHITE), new Vertex(YELLOW, RED, BLUE), new Vertex(YELLOW, BLUE, ORANGE), new Vertex(RED, YELLOW, GREEN),
      new Edge(RED, WHITE), new Edge(YELLOW, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    //    println(s"Generated Rotated\n ${c2}")
    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(RIGHT, ANTICLOCKWISE))
//    println(s"Perfect\n ${c3}")
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("Right layer anti-clockwise rotation") {
    val c1 = Cube.solvedCube.move(Move(RIGHT, ANTICLOCKWISE))
//    println(s"Rotated\n ${c1}")
    assert(Cube.solvedCube.equals(c1) == false)

    val frontLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(ORANGE, YELLOW, BLUE), new Vertex(ORANGE, BLUE, WHITE), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(ORANGE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val backLayer = new Layer(YELLOW,
      new Vertex(RED, BLUE, YELLOW), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(RED, WHITE, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(RED, BLUE))

    val leftLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val rightLayer = new Layer(BLUE,
      new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE),
      new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE), new Edge(BLUE, ORANGE))

    val topLayer = new Layer(ORANGE,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(YELLOW, RED, BLUE),
      new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(YELLOW, BLUE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, GREEN, WHITE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(RED, YELLOW, GREEN),
      new Edge(RED, WHITE), new Edge(WHITE, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val c2 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated Rotated\n ${c2}")
    assert(c2.equals(c1) == true)

    // Move the Front layer anti-clockwise to get back the solved cube
    val c3 = c2.move(Move(RIGHT, CLOCKWISE))
    //    println(s"Perfect\n ${c3}")
    assert(c3.equals(Cube.solvedCube) == true)
  }
}
