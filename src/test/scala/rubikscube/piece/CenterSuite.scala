package rubikscube.piece

/*

import rubikscube.Surface
import rubikscube.meta.Color._
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import rubikscube.meta.Color

import scala.collection.immutable.HashSet

@RunWith(classOf[JUnitRunner])
class CenterSuite extends FunSuite {
  test("Basic equality") {
    for(c <- Color.values) {
      for(f <- Face.values) {
        val c1 = Center(Surface(f, c))
        val c2 = Center(Surface(f, c))

        assert(c1.equals(c2))
      }
    }
  }

  test("Basic inequality") {
    val c1 = Center(Surface(FRONT, BLUE))
    val c2 = Center(Surface(FRONT, GREEN))

    assert(c1.equals(c2) != true)
  }

  test("Same position, must equals") {
    val centers1: HashSet[Center] = HashSet(
      Center(Surface(FRONT, BLUE)), Center(Surface(BACK, GREEN)),
      Center(Surface(LEFT, RED)), Center(Surface(RIGHT, ORANGE)),
      Center(Surface(TOP, WHITE)), Center(Surface(BOTTOM, YELLOW)))

    val centers2: HashSet[Center] = HashSet(
      Center(Surface(FRONT, BLUE)), Center(Surface(BACK, GREEN)),
      Center(Surface(LEFT, RED)), Center(Surface(RIGHT, ORANGE)),
      Center(Surface(TOP, WHITE)), Center(Surface(BOTTOM, YELLOW)))

    assert(centers1.equals(centers2))

    val centers3: HashSet[Center] = HashSet(
      Center(Surface(LEFT, RED)), Center(Surface(RIGHT, ORANGE)),
      Center(Surface(FRONT, BLUE)), Center(Surface(BACK, GREEN)),
      Center(Surface(TOP, WHITE)), Center(Surface(BOTTOM, YELLOW)))

    assert(centers1.equals(centers3))

    val centers4: HashSet[Center] = HashSet(
      Center(Surface(TOP, WHITE)), Center(Surface(BOTTOM, YELLOW)),
      Center(Surface(LEFT, RED)), Center(Surface(RIGHT, ORANGE)),
      Center(Surface(FRONT, BLUE)), Center(Surface(BACK, GREEN)))

    assert(centers1.equals(centers4))
  }

  test("Different position, must NOT equals") {
    val centers1: HashSet[Center] = HashSet(
      Center(Surface(FRONT, BLUE)), Center(Surface(BACK, GREEN)),
      Center(Surface(LEFT, RED)), Center(Surface(RIGHT, ORANGE)),
      Center(Surface(TOP, WHITE)), Center(Surface(BOTTOM, YELLOW)))

    val centers2: HashSet[Center] = HashSet(
      Center(Surface(BACK, BLUE)), Center(Surface(FRONT, GREEN)),
      Center(Surface(LEFT, RED)), Center(Surface(RIGHT, ORANGE)),
      Center(Surface(TOP, WHITE)), Center(Surface(BOTTOM, YELLOW)))

    assert(centers1.equals(centers2) != true)
  }
}
*/
