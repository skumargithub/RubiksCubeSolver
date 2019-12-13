package rubikscube.piece

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import rubikscube.meta.Color
import rubikscube.meta.Color._

@RunWith(classOf[JUnitRunner])
class EdgeSuite extends FunSuite {
  test("Edge equality and not equality") {

    val e1 = new Edge(WHITE, ORANGE)
    val e2 = new Edge(WHITE, ORANGE)

    assert(e1.equals(e1) == true)
    assert(e1.equals(e2) == true)

    val e3 = new Edge(BLUE, ORANGE)
    assert(e1.equals(e3) != true)
  }

  test("Edge partial equality") {
    val e1 = new Edge(WHITE, ORANGE, true, false)

    for(c <- Color.ALL_COLORS.filterNot(WHITE.equals _)) {
      val e2 = new Edge(WHITE, c, true, false)
      assert(e1.equals(e2) == true)
    }
  }
}
