package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //*********Page Variables*********
    String baseURL = "https://www.saucedemo.com/";

    //*********Web Elements by using Page Factory*********
//    @FindBy(how = How.ID, using = "user-name")
//    public WebElement username;

    @FindBy(how = How.ID, using = "txtEmail ")
    public WebElement username;

//    @FindBy(how = How.ID, using = "password")
//    public WebElement password;

    @FindBy(how = How.ID, using = "txtPassword")
    public WebElement password;

//    @FindBy(how = How.ID, using = "login-button")
//    public WebElement loginButton;

    @FindBy(how = How.ID, using = "btnLogin")
    public WebElement loginButton;

//    @FindBy(how = How.CSS, using = ".error-message-container.error")
//    public WebElement errorMessageUsername;

    @FindBy(how = How.CSS, using = "lblEmailErr")
    public WebElement errorMessageUsername;

//    @FindBy(how = How.CSS, using = ".error-message-container.error")
//    public WebElement errorMessagePassword;

    @FindBy(how = How.CSS, using = "lblPasswordErr")
    public WebElement errorMessagePassword;

    @FindBy(how = How.CSS, using = ".header_secondary_container .title")
    public WebElement homepageTitle;

    @FindBy(how = How.CSS, using = "lblLoggedinSuccessfully")
    public WebElement successMessageLogin;

    //*********Page Methods*********
    //Go to LoginPage
    public LoginPage goToLoginPage (){
//        click(signInButton);
        driver.get(baseURL);
        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
        return new PageFactory().initElements(driver,LoginPage.class);
    }

    public void loginToSwagLabs (String pusername, String ppassword){
        //Enter Username(Email)
        wait.until(visibilityOf(username));
        writeText(username,pusername);
        //Enter Password
        wait.until(visibilityOf(password));
        writeText(password, ppassword);
        //Click Login Button
        wait.until(visibilityOf(loginButton));
        click(loginButton);
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
        wait.until(visibilityOf(errorMessageUsername));
        Assert.assertEquals(readText(errorMessageUsername), expectedText);
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
        wait.until(visibilityOf(errorMessagePassword));
        Assert.assertEquals(readText(errorMessagePassword), expectedText);
    }
    //Verify Login Successful
    public void verifyLoginSuccess (String expectedText) {
        wait.until(visibilityOf(homepageTitle));
        Assert.assertEquals(readText(homepageTitle), expectedText);
    }
}
