package rubikscube.solver

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import rubikscube.cube.Cube
import rubikscube.meta.{Direction, Face, Move}

import scala.collection.mutable
import scala.collection.mutable.Set

@RunWith(classOf[JUnitRunner])
class AllUniqeFacesMoveSuite extends FunSuite {
  def getUniqueFaces(numFaces: Int): Set[Face] = {
    val rnd = scala.util.Random
    val allFaces = Face.ALL_FACES.toArray

    val result = mutable.Set[Face]()
    while(result.size < numFaces) {
      val i = rnd.nextInt(allFaces.size)
      result += allFaces(i)
    }

    result
  }

  test("Unique Face moves") {
    val solver = new Solver
    val rnd = scala.util.Random

    for(numFaces <- 1 to Face.ALL_FACES.size) {
//        println(s"# of Faces: ${numFaces}")

      val moves = mutable.ListBuffer[Move]()
      val oppositeMoves = mutable.ListBuffer[Move]()

      val allDirections = Direction.ALL_DIRECTIONS.toArray

        // Generate random moves consisting of numFaces unique faces and a direction (CLOCKWISE or ANTICLOCKWISE)
      for (face <- getUniqueFaces(numFaces)) {
        val direction: Direction = allDirections(rnd.nextInt(2))
        moves += Move(face, direction)
        oppositeMoves.prepend(Move(face, direction.oppose()))
      }
      //    println(s"moves: $moves")

      // Move the solved cube using the generated moves
      val targetCube = moves.foldLeft(Cube.solvedCube)(_ move _)
      //    println(s"targetCube: $targetCube")

      // Now solve the moved cube to the perfect cube
      val solutions = solver.solve(targetCube, Cube.solvedCube, numFaces)
      //    println(solutions)

      // One of the solutions will be the reverse to the original move sequence
      // eg: [(FRONT, CLOCKWISE), (BACK, ANTI_CLOCKWISE), (BOTTOM, CLOCKWISE)] => [(BOTTOM, ANTI_CLOCKWISE), (BACK, CLOCKWISE), (FRONT, ANTI_CLOCKWISE)]
      assert(solutions.contains(oppositeMoves.toList))
    }
  }

}
