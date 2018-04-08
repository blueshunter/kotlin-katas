package gameoflife

data class Game(private var gridOfCells: String) {

    private var currentGeneration: Array<CharArray>

    init {
        GridStringValidator().validate(gridOfCells)

        currentGeneration = gridOfCells
                .split('\n')
                .map {
                    it.toCharArray()
                }
                .toTypedArray()
    }

    fun show() = currentGeneration.joinToString("\n") { it.joinToString("") }

    fun next() {
        var nextGeneration = currentGeneration.map { it.clone() }.toTypedArray()

        for(rowIndex in 0 until nextGeneration.count()) {
            for(columnIndex in 0 until nextGeneration[rowIndex].count()) {

                val cell = Pair(rowIndex, columnIndex)
                val numberOfLiveNeighbours = currentGeneration.getNumberOfLiveNeighbours(cell)

                val isAlive = currentGeneration.isAlive(cell)
                val isOvercrowding = numberOfLiveNeighbours > 3
                val isUnderpopulated = numberOfLiveNeighbours < 2
                val hasThreeNeighbours = (numberOfLiveNeighbours == 3)
                val hasTwoOrThreeNeighbours = (numberOfLiveNeighbours == 2 || numberOfLiveNeighbours == 3)

                when {
                    isAlive && isOvercrowding -> nextGeneration.kill(cell)
                    isAlive && isUnderpopulated -> nextGeneration.kill(cell)
                    isAlive && hasTwoOrThreeNeighbours -> nextGeneration.live(cell)
                    !isAlive && hasThreeNeighbours -> nextGeneration.live(cell)
                    else -> {

                    }
                }
            }
        }
        currentGeneration = nextGeneration.map { it.clone() }.toTypedArray()
    }
}




