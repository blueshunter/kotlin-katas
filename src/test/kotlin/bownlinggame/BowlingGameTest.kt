package bownlinggame

import bowlinggame.Game
import junit.framework.TestCase
import org.junit.Test

class BowlingGameTest : TestCase() {

    lateinit var game: Game

    override fun setUp() {
        super.setUp()
        game = Game()
    }

    private fun rollMany(balls: Int, pins: Int) {
        for (i in 1..balls) {
            game.roll(pins)
        }
    }

    @Test
    fun `test when player play all balls in gutter`() {
        rollMany(20, 0)
        assertEquals(0, game.score())
    }

    @Test
    fun `test when player play all balls and roll one at each`() {
        rollMany(20, 1)
        assertEquals(20, game.score())
    }

    @Test
    fun `test one spare`() {
        spare()
        game.roll(3)
        rollMany(17, 0)

        assertEquals(16, game.score())
    }

    private fun spare() {
        game.roll(5)
        game.roll(5)
    }

    @Test fun `test one strike`() {
        strike()
        game.roll(3)
        game.roll(4)
        rollMany(16, 0)

        assertEquals(24, game.score())
    }

    private fun strike() = game.roll(10)

    @Test fun `test game with all strikes`() {
        rollMany(12, 10)
        assertEquals(300, game.score())
    }
}