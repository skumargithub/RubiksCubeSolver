package rubikscube.solver

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import rubikscube.cube._
import rubikscube.meta.Move

@RunWith(classOf[JUnitRunner])
class TwoMoveSolverSuite extends FunSuite {
  test("Two moves") {
    val solver = new Solver

    // Front
    {
      val start = Cube.solvedCube.move(Move.FRONT_CLOCKWISE).move(Move.FRONT_CLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.FRONT_ANTICLOCKWISE, Move.FRONT_ANTICLOCKWISE)) && moves.contains(List(Move.FRONT_CLOCKWISE, Move.FRONT_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.FRONT_ANTICLOCKWISE).move(Move.FRONT_ANTICLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.FRONT_ANTICLOCKWISE, Move.FRONT_ANTICLOCKWISE)) && moves.contains(List(Move.FRONT_CLOCKWISE, Move.FRONT_CLOCKWISE)))
    }

    // Back
    {
      val start = Cube.solvedCube.move(Move.BACK_CLOCKWISE).move(Move.BACK_CLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.BACK_ANTICLOCKWISE, Move.BACK_ANTICLOCKWISE)) && moves.contains(List(Move.BACK_CLOCKWISE, Move.BACK_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_ANTICLOCKWISE).move(Move.BOTTOM_ANTICLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.BOTTOM_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) && moves.contains(List(Move.BOTTOM_CLOCKWISE, Move.BOTTOM_CLOCKWISE)))
    }

    // Left
    {
      val start = Cube.solvedCube.move(Move.LEFT_CLOCKWISE).move(Move.LEFT_CLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.LEFT_ANTICLOCKWISE, Move.LEFT_ANTICLOCKWISE)) || moves.contains(List(Move.LEFT_CLOCKWISE, Move.LEFT_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.LEFT_ANTICLOCKWISE).move(Move.LEFT_ANTICLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.LEFT_ANTICLOCKWISE, Move.LEFT_ANTICLOCKWISE)) || moves.contains(List(Move.LEFT_CLOCKWISE, Move.LEFT_CLOCKWISE)))
    }

    // Right
    {
      val start = Cube.solvedCube.move(Move.RIGHT_CLOCKWISE).move(Move.RIGHT_CLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.RIGHT_ANTICLOCKWISE, Move.RIGHT_ANTICLOCKWISE)) || moves.contains(List(Move.RIGHT_CLOCKWISE, Move.RIGHT_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.RIGHT_ANTICLOCKWISE).move(Move.RIGHT_ANTICLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.RIGHT_ANTICLOCKWISE, Move.RIGHT_ANTICLOCKWISE)) || moves.contains(List(Move.RIGHT_CLOCKWISE, Move.RIGHT_CLOCKWISE)))
    }

    // Top
    {
      val start = Cube.solvedCube.move(Move.TOP_CLOCKWISE).move(Move.TOP_CLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.TOP_ANTICLOCKWISE, Move.TOP_ANTICLOCKWISE)) || moves.contains(List(Move.TOP_CLOCKWISE, Move.TOP_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.TOP_ANTICLOCKWISE).move(Move.TOP_ANTICLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.TOP_ANTICLOCKWISE, Move.TOP_ANTICLOCKWISE)) || moves.contains(List(Move.TOP_CLOCKWISE, Move.TOP_CLOCKWISE)))
    }

    // Bottom
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_CLOCKWISE).move(Move.BOTTOM_CLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.BOTTOM_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) || moves.contains(List(Move.BOTTOM_CLOCKWISE, Move.BOTTOM_CLOCKWISE)))
    }
    {
      val start = Cube.solvedCube.move(Move.BOTTOM_ANTICLOCKWISE).move(Move.BOTTOM_ANTICLOCKWISE)

      // Not possible to solve this in 1 move
      val imoves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 1)
      assert(imoves.size == 0)

      val moves: Set[List[Move]] = solver.solve(start, Cube.solvedCube, 2)
      println(s"moves: ${moves}")

      assert(moves.size == 2)
      assert(moves.contains(List(Move.BOTTOM_ANTICLOCKWISE, Move.BOTTOM_ANTICLOCKWISE)) || moves.contains(List(Move.BOTTOM_CLOCKWISE, Move.BOTTOM_CLOCKWISE)))
    }
  }
}
