package gameoflife

import junit.framework.TestCase

class GenerationTestCase : TestCase() {

    fun `test that Any live cell with fewer than two live neighbours dies, as if caused by underpopulation`() {

        val underpopulationGridString = ".*\n.."


        val game = Game(underpopulationGridString)
        game.next()
        assertEquals(game.show(), "..\n..")
    }


    fun `test that any live cell with more than three live neighbours dies, as if by overcrowding`() {
        val gridUnderTest = "**...\n" +
                                     "**...\n" +
                                     ".....\n" +
                                     ".....\n" +
                                     "....."

        val game = Game(gridUnderTest)
        game.next()
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
        game.next()
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
        game.next()
        assertEquals(game.show(), "........\n" +
                "...**...\n" +
                "...**...\n" +
                "........")
    }


    fun `test that ten cell row show correct form after ten generations`() {
        val gridUnderTest =
            "....................\n" +
                    "....................\n" +
                    "....................\n" +
                    "....................\n" +
                    ".....**********.....\n" +
                    "....................\n" +
                    "....................\n" +
                    "....................\n" +
                    "....................\n" +
                    "...................."

        val game = Game(gridUnderTest)

        for(i in 1..10) {
            game.next()
        }

        val resultExpected =
            "....................\n" +
                    "....................\n" +
                    "....................\n" +
                    "....*..*.**.*..*....\n" +
                    "....****.**.****....\n" +
                    "....*..*.**.*..*....\n" +
                    "....................\n" +
                    "....................\n" +
                    "....................\n" +
                    "...................."



        assertEquals(game.show(), resultExpected)
    }

}