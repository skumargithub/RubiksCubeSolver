package rubikscube.solver

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import rubikscube.cube._
import rubikscube.meta.Move

@RunWith(classOf[JUnitRunner])
class OneMoveSolverSuite extends FunSuite {
  test("One move") {
    val solver = new Solver

    // Front
    {
      val start = Cube.solvedCube.move(Move.FRONT_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.FRONT_ANTICLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.FRONT_ANTICLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.FRONT_CLOCKWISE)))
    }

    // Back
    {
      val start = Cube.solvedCube.move(Move.BACK_CLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.BACK_ANTICLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.BACK_ANTICLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.BACK_CLOCKWISE)))
    }

    // Left
    {
      val start = Cube.solvedCube.move(Move.LEFT_CLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.LEFT_ANTICLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.LEFT_ANTICLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.LEFT_CLOCKWISE)))
    }

    // Right
    {
      val start = Cube.solvedCube.move(Move.RIGHT_CLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.RIGHT_ANTICLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.RIGHT_ANTICLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.RIGHT_CLOCKWISE)))
    }

    // Top
    {
      val start = Cube.solvedCube.move(Move.TOP_CLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.TOP_ANTICLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.TOP_ANTICLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.TOP_CLOCKWISE)))
    }

    // Bottom
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_CLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.BOTTOM_ANTICLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.BOTTOM_ANTICLOCKWISE)

      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
//      println(s"moves: ${moves.head}")

      assert(moves.equals(List(Move.BOTTOM_CLOCKWISE)))
    }
  }
}
