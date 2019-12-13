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

    assert(e1.equals(e1))
    assert(e1.equals(e2))

    val e3 = new Edge(BLUE, ORANGE)
    assert(e1.equals(e3) != true)
  }

  test("Edge partial equality on surface1") {
    // Match only on surface 1
    val e1 = new Edge(WHITE, ORANGE, true, false)

    for(c <- Color.ALL_COLORS.filterNot(WHITE.equals _)) {
      // Both surface match set to true
      val e2 = new Edge(WHITE, c, true, true)
      assert(e1.equals(e2))
      assert(e2.equals(e1))

      // Only surface1 match set to true
      val e3 = new Edge(WHITE, c, true, false)
      assert(e1.equals(e3))
      assert(e3.equals(e1))
    }
  }

  test("Edge partial equality on surface2") {
    // Match only on surface 2
    val e1 = new Edge(ORANGE, WHITE,false, true)

    for(c <- Color.ALL_COLORS.filterNot(WHITE.equals _)) {
      // Both surface match set to true
      val e2 = new Edge(c, WHITE, true, true)
      assert(e1.equals(e2))
      assert(e2.equals(e1))

      // Only surface2 match set to true
      val e3 = new Edge(c, WHITE, false, true)
      assert(e1.equals(e3))
      assert(e3.equals(e1))
    }
  }
}
