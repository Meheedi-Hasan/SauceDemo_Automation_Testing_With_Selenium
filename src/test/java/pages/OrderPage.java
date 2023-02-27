package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class OrderPage {
    WebDriver driver;
    @FindBy(id = "user-name")
    WebElement UserName;
    @FindBy(id = "password")
    WebElement PassWord;

    @FindBy(id = "login-button")
    WebElement loginbtn;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement Addcardbtn;
    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    WebElement CartIconBtn;
    @FindBy(id = "checkout")
    WebElement chekotbtn;
    @FindBy(id = "first-name")
    WebElement namefld;
    @FindBy(id = "last-name")
    WebElement lastfld;
    @FindBy(id = "postal-code")
    WebElement postal_codefld;
    @FindBy(id = "continue")
    WebElement continuebtn;
    @FindBy(id = "finish")
    WebElement finishbtn;

    @FindBy(xpath = "//h2[contains(.,'THANK YOU FOR YOUR ORDER')]")
    WebElement CompleteAsstersion;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }
    public String Purchase(String username, String password) throws IOException, ParseException, InterruptedException {
        UserName.sendKeys(username);
        PassWord.sendKeys(password);
        loginbtn.click();
        Thread.sleep(2000);
        Addcardbtn.click();
        CartIconBtn.click();
        chekotbtn.click();
        Thread.sleep(2000);
        namefld.sendKeys("Mehedi");
        lastfld.sendKeys("Hasan");
        postal_codefld.sendKeys("1230");
        Thread.sleep(2000);
        continuebtn.click();
        Thread.sleep(2000);
        finishbtn.click();
        Thread.sleep(2000);
        return CompleteAsstersion.getText();
    }

}
