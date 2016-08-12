package test;
import org.testng.Assert;
import org.testng.annotations.*;

import com.foodstore.serg.utils.Validator;

import org.testng.Assert;
import org.testng.annotations.*;




public class EmailValidatorTest {

    private Validator validator;

    @BeforeMethod
    public void setUp(){
        validator = new Validator();
    }

    /*
     * /**
     * Validates followings:
     * first part of email before @ can be 4 to 31 length, can contain
     * numbers and letters and also . (dot) and _ (underscore)
     * Part after @ can be at least 1 character long and first character
     * must be a letter. If in this part there are more symbols than one first one should be
     * letter
     * Part after . can be either 2 or 3 characters long
     */
    @DataProvider
    public Object[][] getValidEmails(){
        return new String[][]{
                {"serg@mail.ru"},
                {"serginio12serginio12serginio129@gmail.com"},
                {"se_r@mail.ru"},
                {"numbers1234@gmail.com"},
                {"dot.e@mail.ru"},
                {"serg@i.ru"},
                {"serg@mail.ru"},
                {"serg@mail.com"}
        };
    }

    @Test(dataProvider = "getValidEmails")
    public void correctEmailsVerifying(String correctEmail){
        Assert.assertTrue(validator.validateEmail(correctEmail)
                ,String.format("Email %s is not correct",correctEmail));
    }



    @DataProvider
    public Object[][] getInvalidEmails(){
        return new String[][]{
                {"seg@mail.ru"},
                {"serginio12serginio12serginio1291@gmail.com"},
                {"se_!r@mail.ru"},
                {"numbers&?1234@gmail.com"},
                {"dot.e@mail.1u"},
                {"serg@i.rutiyutyt"},
                {"serg@mail.r"}
        };
    }

    @Test(dataProvider = "getInvalidEmails")
    public void verifyIncorrectEmailsCanNotBeUused(String incorrectEmail){
        Assert.assertFalse(validator.validateEmail(incorrectEmail)
                ,String.format("Email %s is not correct",incorrectEmail));
    }


    @AfterMethod
    public void tearDown(){
        validator = null;
    }
}
