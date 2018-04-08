package gameoflife

import junit.framework.TestCase
import org.junit.Test

class GridTestCase : TestCase() {

    @Test(expected = Test.None::class)
    fun `test new game start must have two dimensional grid of cells`() {
        Game("**\n**")
    }

    @Test(expected = GridException::class)
    fun `test that grid must be have two rows minimum`() {
        try {
            Game("**")
            fail("this must be throw an exception")
        } catch (e: GridException) {
            assertEquals(e.message, GridException.Message.numberOfRowsMinimumRequired)
        }
    }

    @Test(expected = GridException::class)
    fun `test that grid must be have two columns minimum`() {
        try {
            Game("*\n*")
            fail("this must be throw an exception")
        } catch (e: GridException) {
            assertEquals(e.message, GridException.Message.numberOfColumnsMinimumRequired)
        }
    }

    @Test(expected = GridException::class)
    fun `test that grid must be have same number of columns in each rows`() {
        try {
            Game("**\n***")
            fail("this must be throw an exception")
        } catch (e: GridException) {
            assertEquals(e.message, GridException.Message.numberOfColumnsMustBeTheSameInEachRows)
        }
    }
}