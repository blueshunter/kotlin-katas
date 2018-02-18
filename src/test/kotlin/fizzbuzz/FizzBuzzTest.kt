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
        for(i in 1..2) game.getNext()
        assertEquals("Fizz", game.getNext())
    }

    @Test fun `test fifth number is Buzz`() {
        for(i in 1..4) game.getNext()
        assertEquals("Buzz", game.getNext())
    }

    @Test fun `test 6th number is Fizz`() {
        for(i in 1..5) game.getNext()
        assertEquals("Fizz", game.getNext())
    }

    @Test fun `test 10th number is Buzz`() {
        for(i in 1..9) game.getNext()
        assertEquals("Buzz", game.getNext())
    }
}