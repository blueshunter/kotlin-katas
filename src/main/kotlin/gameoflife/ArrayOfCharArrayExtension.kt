package gameoflife

fun Array<CharArray>.kill(cell: Pair<Int, Int>) {
    this[cell.first][cell.second] = '.'
}

fun Array<CharArray>.live(cell: Pair<Int, Int>) {
    this[cell.first][cell.second] = '*'
}

fun Array<CharArray>.isAlive(cell: Pair<Int, Int>) = (this[cell.first][cell.second] == '*')

fun Array<CharArray>.getNumberOfLiveNeighbours(cell: Pair<Int, Int>): Int {
    var neighboursCount = 0

    val lastRow = this.count()
    val lastColumn = this[0].count()

    val offsets = arrayListOf(
            Pair(-1, -1),
            Pair(-1, 0),
            Pair(-1, 1),
            Pair(0, 1),
            Pair(1, 1),
            Pair(1, 0),
            Pair(1, -1),
            Pair(0, -1)
    )

    for (offset in offsets) {

        val neighbourCellRow = cell.first + offset.first
        val neighbourCellColumn = cell.second + offset.second

        if (neighbourCellRow in 0 until lastRow && neighbourCellColumn in 0 until lastColumn) {

            val neighbourCell = Pair(neighbourCellRow, neighbourCellColumn)
            if (this.isAlive(neighbourCell)) neighboursCount++
        }
    }

    return neighboursCount
}