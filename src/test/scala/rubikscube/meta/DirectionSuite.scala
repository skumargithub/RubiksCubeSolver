package rubikscube.meta

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DirectionSuite extends FunSuite {
  test("Directions equality and not equality") {

    assert(Direction.CLOCKWISE == Direction.CLOCKWISE)
    assert(Direction.ANTI_CLOCKWISE == Direction.ANTI_CLOCKWISE)

    assert(Direction.CLOCKWISE != Direction.ANTI_CLOCKWISE)
  }
}
