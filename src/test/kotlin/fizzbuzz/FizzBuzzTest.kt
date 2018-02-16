package fizzbuzz

import junit.framework.TestCase
import org.junit.Test

class FizzBuzzTest : TestCase() {

    lateinit var game: Game

    override fun setUp() {
        super.setUp()
        game = Game()
    }

    @Test
    fun `test show first number`() {
        assertEquals("1", game.getNext())
    }

    @Test fun `test the second number is 2`() {
        game.getNext()
        assertEquals("2", game.getNext())
    }

    @Test fun `test third number is Fizz`() {
        game.getNext()
        game.getNext()
        assertEquals("Fizz", game.getNext())
    }
}