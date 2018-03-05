package password

class Password(
    private val value: String
) {
    val hasSixOrMoreCharacters get() = (value.count() >= 6)
    val hasTenOrMoreCharacters get() = (value.count() >= 10)
    val hasNumber get() = value.contains(regex = Regex("[0-9]"))
    val hasLetter get() = value.contains(regex = Regex("[^0-9]"))
    val hasSpecialCharacter get() =  value.contains(regex = Regex("[^\\w*]"))

    fun checkStrengthForUser(): Boolean {
        return (hasSixOrMoreCharacters
                && hasNumber
                && hasLetter)
    }

    fun checkStrengthForAdmin(): Boolean {
        return (hasTenOrMoreCharacters
                && hasNumber
                && hasLetter
                && hasSpecialCharacter)
    }


}