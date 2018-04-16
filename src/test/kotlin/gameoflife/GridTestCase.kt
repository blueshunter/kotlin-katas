package gameoflife

import junit.framework.TestCase
import org.junit.Test

class GridTestCase : TestCase() {

    @Test(expected = Test.None::class)
    fun `test new game start must have two dimensional grid of cells`() {

    }

    @Test(expected = GridException::class)
    fun `test that grid must be have two rows minimum`() {

    }

    @Test(expected = GridException::class)
    fun `test that grid must be have two columns minimum`() {

    }

    @Test(expected = GridException::class)
    fun `test that grid must be have same number of columns in each rows`() {

    }
}