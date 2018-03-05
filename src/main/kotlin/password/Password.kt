package password

class Password(
    private val value: String
) {

    private var userValidators: List<Validator> = listOf(LengthValidator(7))
    private var adminValidators: List<Validator> = listOf(LengthValidator(10))

    val hasSixOrMoreCharacters get() = (value.count() >= 6)
    val hasTenOrMoreCharacters get() = (value.count() >= 10)
    val hasNumber get() = value.contains(regex = Regex("[0-9]"))
    val hasLetter get() = value.contains(regex = Regex("[^0-9]"))
    val hasSpecialCharacter get() = value.contains(regex = Regex("[^\\w*]"))

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

    enum class Error(message: String) {
        HAS_LESS_THAN_SIX_CHARACTERS("password must have 6 characters minimum"),
        HAS_LESS_THAN_TEN_CHARACTERS("password must have 10 characters minimum"),
        HAS_NUMBER("password must have one number minimum"),
        HAS_LETTER("password must have one letter minimum"),
        HAS_SPECIAL_CHARACTERS("password must have one special character")
    }

    var userErrors: List<Error> = emptyList()
        get() {
            var errors = mutableListOf<Error>()

            when {
                !hasSixOrMoreCharacters -> errors.add(Error.HAS_LESS_THAN_SIX_CHARACTERS)
                !hasNumber -> errors.add(Error.HAS_NUMBER)
                !hasLetter -> errors.add(Error.HAS_LETTER)
                !hasSpecialCharacter -> errors.add(Error.HAS_SPECIAL_CHARACTERS)
            }

            return emptyList()
        }

    var adminErrors: List<Error> = emptyList()
        get() {
            var errors = mutableListOf<Error>()

            when {
                !hasTenOrMoreCharacters -> errors.add(Error.HAS_LESS_THAN_TEN_CHARACTERS)
                !hasNumber -> errors.add(Error.HAS_NUMBER)
                !hasLetter -> errors.add(Error.HAS_LETTER)
                !hasSpecialCharacter -> errors.add(Error.HAS_SPECIAL_CHARACTERS)
            }

            return emptyList()
        }
}