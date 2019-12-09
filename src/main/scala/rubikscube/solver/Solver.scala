package rubikscube.solver

import rubikscube.cube._
import rubikscube.meta._

import scala.collection.mutable.Queue

class CurrentState(val cube: Cube, val moves: List[Move])

class Solver {
  def solve(start: Cube, end: Cube, maxSteps: Int = 10): List[Move] = {
    val queue = Queue[CurrentState]()
    queue.enqueue(new CurrentState(start, List()))

    while(queue.nonEmpty) {
      val state: CurrentState = queue.dequeue()
      if(state.cube.equals(end)) return state.moves

      for(mv <- Move.ALL_MOVES) {
        queue.enqueue(new CurrentState(state.cube.move(mv), mv :: state.moves))
      }
    }

    return List()
  }
}
