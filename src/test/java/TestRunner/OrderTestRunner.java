package TestRunner;

import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPage;

import java.io.IOException;

public class OrderTestRunner extends Setup {
    OrderPage object1;
    Utils utils;
    @Test(enabled = true, priority = 0)
    public void Purchase() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.saucedemo.com/");
        object1 = new OrderPage(driver);
        utils = new Utils();
        utils.getUserCreds(0);
        String actual2 = object1.Purchase(utils.getUsername(), utils.getPassword());
        Assert.assertEquals(actual2, "THANK YOU FOR YOUR ORDER");
        System.out.println("Assertion Done ! Result: " + actual2);
    }
}
