package rubikscube.piece

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
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
}
