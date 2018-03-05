package password

import junit.framework.TestCase

class PasswordTest : TestCase() {

    fun `test than password has 6 or more characters`() {

        assertFalse(Password("1234").hasSixOrMoreCharacters)
        assertTrue(Password("123456").hasSixOrMoreCharacters)
    }

    fun `test password contain one number`() {
        assertTrue(Password("1").userErrors.contains(Password.Error.HAS_NUMBER))
        assertFalse(Password("*").hasNumber)
    }

    fun `test password contain one letter`() {
        assertTrue(Password("é").hasLetter)
        assertFalse(Password("1").hasLetter)
    }

    fun `test than password has 10 or more characters`() {
        assertFalse(Password("1234").hasTenOrMoreCharacters)
        assertTrue(Password("1234567891").hasTenOrMoreCharacters)
    }

    fun `test than password contain one special character`() {
        assertTrue(Password("?").hasSpecialCharacter)
        assertFalse(Password("e").hasSpecialCharacter)
    }

    fun `test check password strength for user`() {
        assertTrue(Password("eéààà9").checkStrengthForUser())
    }

    fun `test check password strength for admin`() {
        assertTrue(Password("eéààà91234").checkStrengthForAdmin())
        assertTrue(Password("eeeeaa....91234").checkStrengthForAdmin())
    }
}