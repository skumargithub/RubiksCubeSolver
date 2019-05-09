package rubikscube.piece

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
//import rubikscube.Surface

@RunWith(classOf[JUnitRunner])
class SurfaceSuite extends FunSuite {
  /*test("All Colors in all faces, must equals") {
    for(c <- Color.values) {
      for(f <- Face.values) {
        val s1 = Surface(f, c)
        val s2 = Surface(f, c)

        assert(s1 == s2)
      }
    }
  }

  test("Colors in different faces, must NOT equals") {
    for(c <- Color.values) {
      for (f <- Face.values) {
        val s1 = Surface(f, c)

        for (f1 <- Face.values.filter(_ != f)) {
          val s2 = Surface(f1, c)
          assert(s1 != s2)
        }
      }
    }
  }*/
}
