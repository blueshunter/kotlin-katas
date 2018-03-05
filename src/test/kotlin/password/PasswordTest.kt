package password

import junit.framework.TestCase

class PasswordTest : TestCase() {

    fun `test than password has 6 or more characters`() {

        assertFalse(Password("1234").hasSixOrMoreCharacters)
        assertTrue(Password("123456").hasSixOrMoreCharacters)
    }

    fun `test password contain one number`() {
        assertTrue(Password("1").hasOneNumber)
        assertFalse(Password("*").hasOneNumber)
    }

    fun `test password contain one letter`() {
        assertTrue(Password("a").hasOneLetter)
        assertFalse(Password("1").hasOneLetter)
    }

    fun `test than password has 10 or more characters`() {
        assertFalse(Password("1234").hasTenOrMoreCharacters)
        assertTrue(Password("1234567891").hasTenOrMoreCharacters)
    }

    fun `test than password contain one special character`() {
        assertTrue(Password("é").hasSpecialCharacter)
        assertFalse(Password("e").hasSpecialCharacter)
    }

    fun `test check password strength with 10 characters password with numbers and letters and accentued letters`() {
        assertTrue(Password("eéààà91234").isStrong())
    }
}