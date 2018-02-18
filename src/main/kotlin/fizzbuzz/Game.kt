package fizzbuzz

class Game {
    private var nextIndex: Int = 0

    fun getNext(): String {
        nextIndex++

        val isDivisibleBy3 = (nextIndex % 3 == 0)
        val isDivisibleBy5 = (nextIndex % 5 == 0)

        return if(isDivisibleBy3) {
            "Fizz"
        } else if(isDivisibleBy5) {
            "Buzz"
        }
        else {
            (nextIndex).toString()
        }
    }
}