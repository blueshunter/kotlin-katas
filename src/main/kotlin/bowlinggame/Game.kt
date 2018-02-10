package bowlinggame

class Game {
    private var rolls = mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    private var currentRoll = 0

    fun roll(pins: Int) {
        rolls[currentRoll++] = pins
    }

    fun score(): Int {
        var score = 0
        var  ballIndex = 0

        for (frame in 1..10) {
            if (isStrike(ballIndex)) {
                score += (10 + strikeBonus(ballIndex))
                ballIndex ++
            } else if(isSpare(ballIndex)) {
                score += (10 + spareBonus(ballIndex))
                ballIndex += 2
            } else {
                score += (rolls[ballIndex] + rolls[ballIndex + 1])
                ballIndex += 2
            }
        }
        return score
    }

    private fun isStrike(ballIndex: Int) = rolls[ballIndex] == 10

    private fun strikeBonus(ballIndex: Int) = rolls[ballIndex + 1] + rolls[ballIndex + 2]

    private fun isSpare(ballIndex: Int) = rolls[ballIndex] + (rolls[ballIndex + 1]) == 10

    private fun spareBonus(ballIndex: Int) = rolls[ballIndex + 2]
}