import org.junit.Assert
import org.junit.Test

/**
 * Created by Sean on 6/2/17.
 */
class CollectionTest {
    @Test
    fun testExt() {
        Assert.assertEquals(listOf(5, 2, 1), getList())
    }
}