
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.foodstore.serg.utils.Validator;

public class PasswordValidatorTest {

	private Validator validator;

	@BeforeMethod
	public void setUp() {
		validator = new Validator();
	}

	/*
	 * Validates password to contain any character and to be from 5 through 25
	 * characters length
	 */

	@DataProvider
	public Object[][] getValidPasswords() {
		return new String[][] { { "12345" }, { "serginio12serinio1212345" }, { "!*&?#" } };
	}

	@Test(dataProvider = "getValidPasswords")
	public void verifyValidPasswords(String validPassword) {
		Assert.assertTrue(validator.validatePassword(validPassword),
				String.format("Password %s is incorrect", validPassword));
	}

	@DataProvider
	public Object[][] getInvalidPasswords() {
		return new String[][] { { "1234" }, { "serginio12serginio12123451" }, { "" } };
	}

	@Test(dataProvider = "getInvalidPasswords")
	public void verifyInvalidPasswords(String invalidPassword) {
		Assert.assertFalse(validator.validatePassword(invalidPassword),
				String.format("Password %s is incorrect", invalidPassword));
	}

	@AfterMethod
	public void tearDown() {
		validator = null;
	}
}
