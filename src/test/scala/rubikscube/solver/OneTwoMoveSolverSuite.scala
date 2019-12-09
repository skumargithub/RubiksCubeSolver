package rubikscube.solver

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import rubikscube.cube._
import rubikscube.meta.Move

@RunWith(classOf[JUnitRunner])
class OneTwoMoveSolverSuite extends FunSuite {
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

  test("Two moves") {
    val solver = new Solver

    // Front
    {
      val start = Cube.solvedCube.move(Move.FRONT_CLOCKWISE).move(Move.FRONT_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.FRONT_ANTICLOCKWISE, Move.FRONT_ANTICLOCKWISE)) || moves.equals(List(Move.FRONT_CLOCKWISE, Move.FRONT_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.FRONT_ANTICLOCKWISE).move(Move.FRONT_ANTICLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.FRONT_ANTICLOCKWISE, Move.FRONT_ANTICLOCKWISE)) || moves.equals(List(Move.FRONT_CLOCKWISE, Move.FRONT_CLOCKWISE)))
    }

    // Back
    {
      val start = Cube.solvedCube.move(Move.BACK_CLOCKWISE).move(Move.BACK_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.BACK_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) || moves.equals(List(Move.BACK_CLOCKWISE, Move.BACK_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_ANTICLOCKWISE).move(Move.BOTTOM_ANTICLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.BOTTOM_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) || moves.equals(List(Move.BACK_CLOCKWISE, Move.BACK_CLOCKWISE)))
    }

    // Left
    {
      val start = Cube.solvedCube.move(Move.LEFT_CLOCKWISE).move(Move.LEFT_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.LEFT_ANTICLOCKWISE, Move.LEFT_ANTICLOCKWISE)) || moves.equals(List(Move.LEFT_CLOCKWISE, Move.LEFT_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.LEFT_ANTICLOCKWISE).move(Move.LEFT_ANTICLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.LEFT_ANTICLOCKWISE, Move.LEFT_ANTICLOCKWISE)) || moves.equals(List(Move.LEFT_CLOCKWISE, Move.LEFT_CLOCKWISE)))
    }

    // Right
    {
      val start = Cube.solvedCube.move(Move.RIGHT_CLOCKWISE).move(Move.RIGHT_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.RIGHT_ANTICLOCKWISE, Move.RIGHT_ANTICLOCKWISE)) || moves.equals(List(Move.RIGHT_CLOCKWISE, Move.RIGHT_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.RIGHT_ANTICLOCKWISE).move(Move.RIGHT_ANTICLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.RIGHT_ANTICLOCKWISE, Move.RIGHT_ANTICLOCKWISE)) || moves.equals(List(Move.RIGHT_CLOCKWISE, Move.RIGHT_CLOCKWISE)))
    }

    // Top
    {
      val start = Cube.solvedCube.move(Move.TOP_CLOCKWISE).move(Move.TOP_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.TOP_ANTICLOCKWISE, Move.TOP_ANTICLOCKWISE)) || moves.equals(List(Move.TOP_CLOCKWISE, Move.TOP_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.TOP_ANTICLOCKWISE).move(Move.TOP_ANTICLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.TOP_ANTICLOCKWISE, Move.TOP_ANTICLOCKWISE)) || moves.equals(List(Move.TOP_CLOCKWISE, Move.TOP_CLOCKWISE)))
    }

    // Bottom
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_CLOCKWISE).move(Move.BOTTOM_CLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.BOTTOM_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) || moves.equals(List(Move.BOTTOM_CLOCKWISE, Move.BOTTOM_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_ANTICLOCKWISE).move(Move.BOTTOM_ANTICLOCKWISE)
      val moves: List[Move] = solver.solve(start, Cube.solvedCube, 1)
      println(s"moves: ${moves}")

      assert(moves.equals(List(Move.BOTTOM_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) || moves.equals(List(Move.BOTTOM_CLOCKWISE, Move.BOTTOM_CLOCKWISE)))
    }
  }
}
