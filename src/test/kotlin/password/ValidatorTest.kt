package password

import junit.framework.TestCase

class ValidatorTest: TestCase() {

    fun `test lenghtValidator return no errors if value has lenght is lesser that limit length`(){
        assertTrue(LengthValidator(7).validate("1234567").isNullOrEmpty())
        assertNotNull(LengthValidator(7).validate("1567"))
    }
}