package TestRunner;

import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils;

    @Test(enabled = true, priority = 0)
    public void Login_With_valid() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils(driver);
        utils.getUserCreds(0);
        String nn = loginPage.Login_With_valid(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(nn, "PRODUCTS");
        System.out.println("Assertion Done ! Result : " + nn);

    }
    @Test(enabled = true, priority = 1)
    public void Login_With_Wrong() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils(driver);
        utils.getUserCreds(1);
        String actual1 = loginPage.Login_With_Wrong(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(actual1, "Epic sadface: Username and password do not match any user in this service");
        System.out.println("Assertion Done ! Result: " + actual1);
    }

}
