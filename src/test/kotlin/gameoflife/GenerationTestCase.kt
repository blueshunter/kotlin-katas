package gameoflife

import junit.framework.TestCase

class GenerationTestCase : TestCase() {

    fun `test that Any live cell with fewer than two live neighbours dies, as if caused by underpopulation`() {

        val underpopulationGridString = ".*\n.."


        val game = Game(underpopulationGridString)
        println(game.show())
        game.next()
        println("\n----next-----\n")
        println(game.show())
        assertEquals(game.show(), "..\n..")
    }


    fun `test that any live cell with more than three live neighbours dies, as if by overcrowding`() {
        val gridUnderTest = "**...\n" +
                                     "**...\n" +
                                     ".....\n" +
                                     ".....\n" +
                                     "....."

        val game = Game(gridUnderTest)
        println(game.show())
        game.next()
        println("\n----next-----\n")
        println(game.show())
        assertEquals(game.show(), "**...\n" +
                "**...\n" +
                ".....\n" +
                ".....\n" +
                ".....")
    }


    fun `test that Any live cell with two or three live neighbours lives on to the next generation`() {
        val gridUnderTest = ".....\n" +
                "..*..\n" +
                ".*.*.\n" +
                "..*..\n" +
                "....."

        val game = Game(gridUnderTest)
        println(game.show())
        game.next()
        println("\n----next-----\n")
        println(game.show())
        assertEquals(game.show(), ".....\n" +
                "..*..\n" +
                ".*.*.\n" +
                "..*..\n" +
                ".....")
    }

    fun `test that any dead cell with exactly three live neighbours becomes a live cell`() {
        val gridUnderTest = "........\n" +
                "....*...\n" +
                "...**...\n" +
                "........"

        val game = Game(gridUnderTest)
        println(game.show())
        game.next()
        println("\n----next-----\n")
        println(game.show())
        assertEquals(game.show(), "........\n" +
                "...**...\n" +
                "...**...\n" +
                "........")
    }
}