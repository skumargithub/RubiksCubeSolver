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
      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.FRONT_ANTI_CLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.FRONT_ANTI_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.FRONT_CLOCKWISE)))
    }

    // Back
    {
      val start = Cube.solvedCube.move(Move.BACK_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.BACK_ANTI_CLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.BACK_ANTI_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.BACK_CLOCKWISE)))
    }

    // Left
    {
      val start = Cube.solvedCube.move(Move.LEFT_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.LEFT_ANTI_CLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.LEFT_ANTI_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.LEFT_CLOCKWISE)))
    }

    // Right
    {
      val start = Cube.solvedCube.move(Move.RIGHT_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.RIGHT_ANTI_CLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.RIGHT_ANTI_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.RIGHT_CLOCKWISE)))
    }

    // Top
    {
      val start = Cube.solvedCube.move(Move.TOP_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.TOP_ANTI_CLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.TOP_ANTI_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.TOP_CLOCKWISE)))
    }

    // Bottom
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.BOTTOM_ANTI_CLOCKWISE)))
    }

    {
      val start = Cube.solvedCube.move(Move.BOTTOM_ANTI_CLOCKWISE)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      println(s"""moves.size: ${moves.size}, moves:\n${moves.mkString("\n")}""")

      assert(moves.size == 1 && moves.contains(List(Move.BOTTOM_CLOCKWISE)))
    }
  }
}
