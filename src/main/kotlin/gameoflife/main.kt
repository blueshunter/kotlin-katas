package gameoflife

fun main(args: Array<String>) {

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

    var frame = 0
    while (frame < 10000) {
        println(String.format("\b\b\b\b\b"))
        println(game.show())
        Thread.sleep(1000)
        game.next()
        frame++
    }
}