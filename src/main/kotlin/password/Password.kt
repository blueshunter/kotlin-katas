package password

class Password(
    private val value: String
) {
    val hasSixOrMoreCharacters get() = (value.count() >= 6)
    val hasTenOrMoreCharacters get() = (value.count() >= 10)
    val hasOneNumber get() = value.contains(regex = Regex("[0-9]"))
    val hasOneLetter get() = value.contains(regex = Regex("[^0-9]"))
    val hasSpecialCharacter get() = value.contains(regex = Regex("[^\\w*]"))

    fun isStrong(): Boolean {
        return (hasTenOrMoreCharacters
                && hasOneNumber
                && hasOneLetter
                && hasSpecialCharacter)
    }

}