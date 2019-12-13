package rubikscube.piece

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import rubikscube.meta.Color
import rubikscube.meta.Color._

@RunWith(classOf[JUnitRunner])
class VertexSuite extends FunSuite {
  test("Vertex equality and not equality") {

    val v1 = new Vertex(WHITE, ORANGE, GREEN)
    val v2 = new Vertex(WHITE, ORANGE, GREEN)

    assert(v1.equals(v1) == true)
    assert(v1.equals(v2) == true)

    val v3 = new Vertex(BLUE, ORANGE, GREEN)
    assert(v1.equals(v3) != true)
  }

  test("Vertex partial equality 2 faces") {
    val v1 = new Vertex(WHITE, ORANGE, GREEN, true, true, false)

    for(c <- Color.ALL_COLORS.filterNot(GREEN.equals _)) {
      val v2 = new Vertex(WHITE, ORANGE, c, true, true, false)
      assert(v1.equals(v2) == true)
    }
  }

  test("Vertex partial equality 1 face") {
    val v1 = new Vertex(WHITE, ORANGE, GREEN, true, false, false)

    for(c <- Color.ALL_COLORS.filterNot(GREEN.equals _)) {
      val v2 = new Vertex(WHITE, BLUE, c, true, true, false)
      assert(v1.equals(v2) == true)
    }
  }
}
