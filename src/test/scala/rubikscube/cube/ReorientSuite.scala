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
class ReorientSuite extends FunSuite {
  test("FRONT reoriented to FRONT (NO-OP") {
    val cr = Cube.solvedCube.reorientToFront(FRONT)

    // Reoriented the FRONT face to FRONT should be a NO-OP
    assert(Cube.solvedCube.equals(cr) == true)
  }

  test("BACK reoriented TO FRONT") {
    // Reorient BACK to FRONT
    val cr = Cube.solvedCube.reorientToFront(BACK)
//    println(s"Back Reoriented: ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val backLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val leftLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val rightLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE), new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN),
      new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE), new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val c1 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated Reoriented\n ${c1}")
    assert(cr.equals(c1) == true)

    // Now reorient BACK to FRONT to get back the original cube
    val c3 = cr.reorientToFront(BACK)
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("TOP reoriented TO FRONT") {
    // Reorient TOP to FRONT
    val cr = Cube.solvedCube.reorientToFront(TOP)
//    println(s"Top Reoriented\n ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(ORANGE,
      new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE),
      new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE))

    val backLayer = new Layer(RED,
      new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN),
      new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN))

    val leftLayer = new Layer(BLUE,
      new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED),
      new Edge(BLUE, WHITE), new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED))

    val rightLayer = new Layer(GREEN,
      new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW), new Vertex(GREEN, YELLOW, ORANGE),
      new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW), new Edge(GREEN, ORANGE))

    val topLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val bottomLayer = new Layer(YELLOW,
      new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE), new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN),
      new Edge(YELLOW, RED), new Edge(YELLOW, BLUE), new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN))

    val c1 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    //    println(s"Generated Reoriented\n ${c1}")
    assert(cr.equals(c1) == true)

    // Now reorient TOP to FRONT to get back the original cube
    val c3 = cr.reorientToFront(TOP)
    assert(c3.equals(Cube.solvedCube) == true)
  }


  test("BOTTOM reoriented TO FRONT") {
    // Reorient BOTTOM to FRONT
    val cr = Cube.solvedCube.reorientToFront(BOTTOM)
//    println(s"BOTTOM Reoriented\n ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(RED,
      new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN), new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE),
      new Edge(RED, YELLOW), new Edge(RED, GREEN), new Edge(RED, WHITE), new Edge(RED, BLUE))

    val backLayer = new Layer(ORANGE,
      new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE), new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN),
      new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE), new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN))

    val leftLayer = new Layer(BLUE,
      new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE), new Vertex(BLUE, WHITE, ORANGE),
      new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE), new Edge(BLUE, ORANGE))

    val rightLayer = new Layer(GREEN,
      new Vertex(GREEN, RED, YELLOW), new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED),
      new Edge(GREEN, YELLOW), new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED))

    val topLayer = new Layer(YELLOW,
      new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE), new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN),
      new Edge(YELLOW, RED), new Edge(YELLOW, BLUE), new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN))

    val bottomLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val c1 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
//    println(s"Generated Reoriented\n ${c1}")
    assert(cr.equals(c1) == true)

    // Now reorient TOP to FRONT to get back the original cube
    val c3 = cr.reorientToFront(BOTTOM)
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("LEFT reoriented TO FRONT") {
    // Reorient BOTTOM to FRONT
    val cr = Cube.solvedCube.reorientToFront(LEFT)
//    println(s"LEFT Reoriented\n ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW),
     new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val backLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val leftLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val rightLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW), new Vertex(ORANGE, YELLOW, BLUE), new Vertex(ORANGE, BLUE, WHITE),
      new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW), new Edge(ORANGE, BLUE), new Edge(ORANGE, WHITE))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW), new Vertex(RED, YELLOW, GREEN), new Vertex(RED, GREEN, WHITE),
      new Edge(RED, BLUE), new Edge(RED, YELLOW), new Edge(RED, GREEN), new Edge(RED, WHITE))

    val c1 = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    //    println(s"Generated Reoriented\n ${c1}")
    assert(cr.equals(c1) == true)

    // Now reorient RIGHT to FRONT to get back the original cube
    val c3 = cr.reorientToFront(RIGHT)
//    println(s"Reoriented back\n ${c3}")
    assert(c3.equals(Cube.solvedCube) == true)
  }

  test("RIGHT reoriented TO FRONT") {
    // Reorient RIGHT to FRONT
    val cr = Cube.solvedCube.reorientToFront(RIGHT)
//    println(s"RIGHT Reoriented\n ${cr}")
    assert(Cube.solvedCube.equals(cr) == false)

    val frontLayer = new Layer(BLUE,
      new Vertex(BLUE, WHITE, ORANGE), new Vertex(BLUE, ORANGE, YELLOW), new Vertex(BLUE, YELLOW, RED), new Vertex(BLUE, RED, WHITE),
      new Edge(BLUE, ORANGE), new Edge(BLUE, YELLOW), new Edge(BLUE, RED), new Edge(BLUE, WHITE))

    val backLayer = new Layer(GREEN,
      new Vertex(GREEN, YELLOW, ORANGE), new Vertex(GREEN, ORANGE, WHITE), new Vertex(GREEN, WHITE, RED), new Vertex(GREEN, RED, YELLOW),
      new Edge(GREEN, ORANGE), new Edge(GREEN, WHITE), new Edge(GREEN, RED), new Edge(GREEN, YELLOW))

    val leftLayer = new Layer(WHITE,
      new Vertex(WHITE, GREEN, ORANGE), new Vertex(WHITE, ORANGE, BLUE), new Vertex(WHITE, BLUE, RED), new Vertex(WHITE, RED, GREEN),
      new Edge(WHITE, ORANGE), new Edge(WHITE, BLUE), new Edge(WHITE, RED), new Edge(WHITE, GREEN))

    val rightLayer = new Layer(YELLOW,
      new Vertex(YELLOW, BLUE, ORANGE), new Vertex(YELLOW, ORANGE, GREEN), new Vertex(YELLOW, GREEN, RED), new Vertex(YELLOW, RED, BLUE),
      new Edge(YELLOW, ORANGE), new Edge(YELLOW, GREEN), new Edge(YELLOW, RED), new Edge(YELLOW, BLUE))

    val topLayer = new Layer(ORANGE,
      new Vertex(ORANGE, YELLOW, BLUE), new Vertex(ORANGE, BLUE, WHITE), new Vertex(ORANGE, WHITE, GREEN), new Vertex(ORANGE, GREEN, YELLOW),
      new Edge(ORANGE, BLUE), new Edge(ORANGE, WHITE), new Edge(ORANGE, GREEN), new Edge(ORANGE, YELLOW))

    val bottomLayer = new Layer(RED,
      new Vertex(RED, YELLOW, GREEN), new Vertex(RED, GREEN, WHITE), new Vertex(RED, WHITE, BLUE), new Vertex(RED, BLUE, YELLOW),
      new Edge(RED, GREEN), new Edge(RED, WHITE), new Edge(RED, BLUE), new Edge(RED, YELLOW))

    val cg = new Cube(frontLayer, backLayer, leftLayer, rightLayer, topLayer, bottomLayer)
    //    println(s"Generated Reoriented\n ${cg}")
    assert(cr.equals(cg) == true)

    // Now reorient LEFT to FRONT to get back the original cube
    val c3 = cr.reorientToFront(LEFT)
//    println(s"Reoriented back\n ${c3}")
    assert(c3.equals(Cube.solvedCube) == true)
  }
}
