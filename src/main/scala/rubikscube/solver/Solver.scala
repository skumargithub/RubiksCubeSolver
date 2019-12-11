package rubikscube.solver

import rubikscube.cube._
import rubikscube.meta._

import scala.collection.mutable.{ListBuffer, Queue}

class CurrentState(val cube: Cube, val moves: List[Move])

class Solver {
  // Find ALL solutions (within maxSteps) to from from start to end
  def solve(start: Cube, end: Cube, maxSteps: Int = 10): Set[List[Move]] = {
    val queue = Queue[CurrentState]()
    queue.enqueue(new CurrentState(start, List()))

    val currentSolutionMoves = ListBuffer[List[Move]]()

    while(queue.nonEmpty) {
      val currentState: CurrentState = queue.dequeue()

      currentState.cube.equals(end) match {
        case true =>
          currentSolutionMoves += currentState.moves      // This is a solution
//          println(s"foundSolution: ${currentState.moves}")
        case _ =>
          currentState.moves.length < maxSteps match {
            case true =>
              // Skip the move that's the opposite of the previous move we made
              val prevMoveOpposite: Option[Move] = currentState.moves.headOption.map(_.oppose)
              val possibleMoves: Set[Move] = Move.ALL_MOVES.filterNot(mv => prevMoveOpposite.map(_.equals(mv)).getOrElse(false))
//              println(s"Possible Moves: $possibleMoves")
              for (mv <- possibleMoves) {
                val newState = new CurrentState(currentState.cube.move(mv), currentState.moves ::: List(mv))
//                println(s"newState: ${newState.moves}")
                queue.enqueue(newState)
              }
            case _ =>
          }
      }
    }

    currentSolutionMoves.sortWith(_.size < _.size).toSet        // Unique moves, ordered by number of moves (min to max)
  }
}
