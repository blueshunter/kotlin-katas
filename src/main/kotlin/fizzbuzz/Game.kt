package fizzbuzz

class Game {
    var nextIndex: Int = 0

    fun getNext(): String {
        nextIndex++

        return if(isThreeNumber(nextIndex)) {
            "Fizz"
        } else {
            (nextIndex).toString()
        }
    }

    private fun isThreeNumber(number: Int) = (number == 3)
}