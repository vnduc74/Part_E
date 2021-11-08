package test;

import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTests extends BaseTest {

    @Test (priority = 0)
    public void invalidLoginTest () throws InterruptedException {
        //Open SwagLabs LoginPage
        //Initialize elements by using PageFactory
        page.GetInstance(LoginPage.class).goToLoginPage();

        //Go to Login Page and then LoginToSwagLabs)
        page.GetInstance(LoginPage.class).
                goToLoginPage().loginToSwagLabs("duc.vo@s3corp.com.vn", "1231234");

        //*************ASSERTIONS***********************
        page.GetInstance(LoginPage.class).verifyLoginPassword(("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test (priority = 1)
    public void validLoginTest () throws InterruptedException {
        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open SwagLabs LoginPage
        page.GetInstance(LoginPage.class).goToLoginPage();

        //Method Chaining (Go to Login Page and then LoginToSwagLabs)
        page.GetInstance(LoginPage.class).goToLoginPage().loginToSwagLabs("standard_user","secret_sauce");

        //*************ASSERTIONS***********************
        page.GetInstance(LoginPage.class).verifyLoginSuccess("PRODUCTS");
    }

}