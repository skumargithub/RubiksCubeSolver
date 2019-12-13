package rubikscube.solver

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable.{ListBuffer, Set}
import rubikscube.cube._
import rubikscube.meta.Direction._
import rubikscube.meta.Face._
import rubikscube.meta.{Direction, Face, Move}

import scala.collection.mutable

@RunWith(classOf[JUnitRunner])
class ThreeMoveSolverSuite extends FunSuite {
  def getThreeUniqueFaces(): Set[Face] = {
    val rnd = scala.util.Random
    val allFaces = Face.ALL_FACES.toArray

    val result = mutable.Set[Face]()
    while(result.size < 3) {
      val i = rnd.nextInt(allFaces.size)
      result += allFaces(i)
    }

    result
  }

  test("Three moves") {
    val solver = new Solver
    val rnd = scala.util.Random

    for(i <- 0 to 100) {
      // Generate 3 random moves consisting of 3 unique faces and a direction (CLOCKWISE or ANTICLOCKWISE)
      val moves = mutable.ListBuffer[Move]()
      val oppositeMoves = mutable.ListBuffer[Move]()
      val allDirections = Direction.ALL_DIRECTIONS.toArray
      for (face <- getThreeUniqueFaces) {
        val direction: Direction = allDirections(rnd.nextInt(2))
        moves += Move(face, direction)
        oppositeMoves += Move(face, direction.oppose())
      }
      //    println(s"moves: $moves")

      // Move the solved cube using the generated 3 moves
      val targetCube = moves.foldLeft(Cube.solvedCube)(_ move _)
      //    println(s"targetCube: $targetCube")

      // Now solve the moved cube to the perfect cube
      val solutions = solver.solve(targetCube, Cube.solvedCube, 3)
      //    println(solutions)

      // We should have the solution with the moves that are opposite to the original move sequence
      // eg: [(FRONT, CLOCKWISE), (BACK, ANTI_CLOCKWISE), (BOTTOM, CLOCKWISE)] => [(BOTTOM, ANTI_CLOCKWISE), (BACK, CLOCKWISE), (FRONT, ANTI_CLOCKWISE)]
//      println(s"solution size: ${solutions.size}")
//      if(solutions.size == 2) {
//        println(s"moves: $moves")
//        println(s"soln: $solutions")
//      }
      assert(solutions.contains(oppositeMoves.reverse.toList))
    }
  }
}
