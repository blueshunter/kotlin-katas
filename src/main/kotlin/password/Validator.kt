package password


interface Validator {
    fun validate(value: String): String?
}

class LengthValidator(private val lenght: Int): Validator {

    override fun validate(value: String) = if (checkLength(value)) null else "Password must have $lenght characters"

    private fun checkLength(value: String) = (value.count() >= lenght)
}

