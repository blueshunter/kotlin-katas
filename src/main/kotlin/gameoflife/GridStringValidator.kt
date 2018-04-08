package gameoflife

class GridStringValidator {

    fun validate(gridOfCells: String) {

        val rows = gridOfCells.split('\n')

        if(rows.count() < 2) throw GridException.numberOfRowsMinimumRequired

        var columnCount: Int? = null
        for (row in rows) {
            if(columnCount != null && columnCount != row.count()) throw GridException.numberOfColumnsMustBeTheSameInEachRows

            columnCount = row.count()

            if(columnCount < 2) throw GridException.numberOfColumnsMinimumRequired
        }
    }
}

class GridException(message: String? = Message.default) : Exception(message) {

    companion object Factory {
        val numberOfRowsMinimumRequired = GridException(Message.numberOfRowsMinimumRequired)
        val numberOfColumnsMinimumRequired = GridException(Message.numberOfColumnsMinimumRequired)
        val numberOfColumnsMustBeTheSameInEachRows = GridException(Message.numberOfColumnsMustBeTheSameInEachRows)
    }

    object Message {
        const val default = "Invalid grid"
        const val numberOfRowsMinimumRequired = "Minimum of 2 rows is required to play"
        const val numberOfColumnsMinimumRequired = "Minimum of two columns is required to play"
        const val numberOfColumnsMustBeTheSameInEachRows = "number of columns must be the same in each rows"
    }
}